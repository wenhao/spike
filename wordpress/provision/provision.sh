#!/bin/bash

# Install MySQL
echo 'mysql-server mysql-server/root_password password vagrant' | sudo debconf-set-selections
echo 'mysql-server mysql-server/root_password_again password vagrant' | sudo debconf-set-selections
apt-get -y install mysql-client mysql-server

# Install php and apache2
apt-get install -y vim curl python-software-properties
add-apt-repository -y ppa:ondrej/php5
apt-get update

apt-get install -y apache2 apache2-utils nano git-core unzip
apt-get install -y php5 php5-mysql php-pear libapache2-mod-php5 php5-dev php5-gd libssh2-php php5-mcrypt dbconfig-common sendmail
sudo cp /vagrant/config/php.ini /etc/php5/apache2/php.ini
a2enmod rewrite
apachectl restart

# Install WP-CLI
sudo curl -O https://raw.githubusercontent.com/wp-cli/builds/gh-pages/phar/wp-cli.phar
sudo chmod +x wp-cli.phar
sudo mv wp-cli.phar /usr/local/bin/wp

# Setup permissions for the user 'vagrant'
sudo usermod -a -G www-data vagrant

# Create database for WordPress
echo "create database wordpress" | mysql -u root -pvagrant

# Get WordPress and set it up
cd /var/www/html
rm index.html
wp core download --allow-root
wp core config --dbname='wordpress' --dbuser='root' --dbpass='vagrant' --allow-root
wp core install --url=localhost:8080 --title='WordPress' --admin_user=admin --admin_password='admin' --admin_email="admin@wordpress.localhost" --allow-root
wp plugin install advanced-custom-fields --activate --allow-root
wp plugin install acf-field-date-time-picker --activate --allow-root
wp plugin install timber-library --activate --allow-root
wp plugin install debug-bar --activate --allow-root
wp plugin install pronamic-google-maps --activate --allow-root
wp plugin install piklist --activate --allow-root
wp plugin install linkedin-login --activate --allow-root
wp plugin install wp-mail-smtp --activate --allow-root
wp theme activate salient --allow-root

# Fix permissions for /var/www -folder
chown -R www-data /var/www
chgrp -R www-data /var/www
chmod -R 775 /var/www

