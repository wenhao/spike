provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region = "${var.region}"
}

resource "aws_instance" "example" {
  ami = "ami-061392db613a6357b"
  instance_type = "t2.micro"

  depends_on = ["aws_s3_bucket.example"]

  provisioner "local-exec" {
      command = "echo ${aws_instance.example.public_ip} > ip_address.txt"
  }
}

resource "aws_eip" "ip" {
  instance = "${aws_instance.example.id}"
}

resource "aws_s3_bucket" "example" {
  bucket = "terraform-wenhao-getting-started-guide"
  acl = "private"
}

output "ip" {
  value = "${aws_eip.ip.public_ip}"
}