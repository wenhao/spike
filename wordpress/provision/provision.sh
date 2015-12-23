#!/bin/bash

# ENVS
DBNAME='wordpress'
DBPASSWORD='vagrant'

# Install MySQL
echo -e "\n--- Install MySQL specific packages and settings ---\n"
echo "mysql-server mysql-server/root_password password $DBPASSWORD" | debconf-set-selections
echo "mysql-server mysql-server/root_password_again password $DBPASSWORD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/dbconfig-install boolean true" | debconf-set-selections
echo "phpmyadmin phpmyadmin/app-password-confirm password $DBPASSWORD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/mysql/admin-pass password $DBPASSWORD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/mysql/app-pass password $DBPASSWORD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/reconfigure-webserver multiselect none" | debconf-set-selections
apt-get install -y mysql-client mysql-server phpmyadmin

# Install php and apache2
apt-get install -y python-software-properties
add-apt-repository -y ppa:ondrej/php5
apt-get update

apt-get install -y apache2 apache2-utils nano git-core unzip
apt-get install -y php5 php5-mysql php-pear libapache2-mod-php5 php5-dev php5-gd libssh2-php php5-mcrypt dbconfig-common sendmail
# Add ServerName to httpd.conf
sed -i '$a\ServerName localhost' /etc/apache2/apache2.conf
sed -i '$a\Include /etc/phpmyadmin/apache.conf' /etc/apache2/apache2.conf
sudo cp /vagrant/config/000-default.conf /etc/apache2/sites-available/000-default.conf
a2enmod rewrite

# Install WP-CLI
sudo curl -O https://raw.githubusercontent.com/wp-cli/builds/gh-pages/phar/wp-cli.phar
sudo chmod +x wp-cli.phar
sudo mv wp-cli.phar /usr/local/bin/wp

# Setup permissions for the user 'vagrant'
sudo usermod -a -G www-data vagrant

# Create database for WordPress
echo "create database $DBNAME" | mysql -u root -p$DBPASSWORD

# Get WordPress and set it up
cd /var/www/html
rm index.html
wp core download --allow-root
wp core config --dbname='wordpress' --dbuser='root' --dbpass='vagrant' --allow-root --extra-php <<PHP
define( 'WP_DEBUG', true );
define( 'WP_DEBUG_LOG', true );
PHP
wp core install --url=localhost:9999 --title='WordPress' --admin_user=admin --admin_password='admin' --admin_email="admin@wordpress.localhost" --allow-root
wp plugin install advanced-custom-fields --activate --allow-root
wp plugin install acf-field-date-time-picker --activate --allow-root
wp plugin install timber-library --activate --allow-root
wp plugin install debug-bar --activate --allow-root
wp plugin install pronamic-google-maps --activate --allow-root
wp plugin install piklist --activate --allow-root
wp plugin install linkedin-login --activate --allow-root
wp plugin install wp-mail-smtp --activate --allow-root
# wp theme activate salient --allow-root

# Fix permissions for /var/www -folder
sudo touch /var/www/html/.htaccess
chown -R www-data /var/www
chgrp -R www-data /var/www
chmod -R 775 /var/www

service mysql restart
service apache2 restart

