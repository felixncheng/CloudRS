change master to
    master_host='mysql-master',
    master_port=3306,
    master_user='slave',
    master_password='123456',
    master_log_file='mysql-bin.000003',
    master_log_pos=155;

start slave;