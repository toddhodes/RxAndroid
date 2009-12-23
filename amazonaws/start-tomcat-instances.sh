
export AWS_ELB_HOME=~/svn/users/todd/amazonaws/tools/ElasticLoadBalancing-1.0.3.4/
echo setting paths and credentials

export EC2_PRIVATE_KEY=~/svn/users/todd/amazonaws/pk-COPS5EWHDTA2KPEVTNLXL2GJE524KSOG.pem
export EC2_CERT=~/svn/users/todd/amazonaws/cert-COPS5EWHDTA2KPEVTNLXL2GJE524KSOG.pem

export AWS_CREDENTIAL_FILE=~/svn/users/todd/amazonaws/tools/ElasticLoadBalancing-1.0.3.4/credential-file
export AWS_ELB_HOME=~/svn/users/todd/amazonaws/tools/ElasticLoadBalancing-1.0.3.4/
export EC2_HOME=~/svn/users/todd/amazonaws/tools/ec2-api-tools-1.3-46266
#PATH=$PATH:$EC2_HOME:$AWS_ELB_HOME


echo checking for keypairs
$EC2_HOME/bin/ec2-describe-keypairs
./tools/aws describe-keypairs



echo aquire ec2 instances w/ tomcat image
ec2run ami-45e7002c -m -z us-east-1a  -k EC2-keypair -f /etc/init.d/tomcat  -n 2
ec2-describe-instances

$EC2_HOME/bin/ec2-authorize default -p 22
$EC2_HOME/bin/ec2-authorize default -p 80
$EC2_HOME/bin/ec2-authorize default -p 8080

echo creating elb 
$AWS_ELB_HOME/bin/elb-create-lb todd-lb --availability-zones us-east-1a --listener "protocol=http, lb-port=80, instance-port=8080"

echo query elb 
$AWS_ELB_HOME/bin/elb-describe-lbs
