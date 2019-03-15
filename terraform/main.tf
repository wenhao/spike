module "awsEc2" {
  source = "./modules/example"

  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region = "${var.region}"
}
