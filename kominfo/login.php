
<?php 
     include 'koneksi.php';
    $username     = $_POST['username'];
    $pass     = $_POST['pass'];

    $sql_cek = "SELECT * FROM costumer_ WHERE username='".$username."' AND pass='".$pass."' ;";
    $result_cek = mysqli_query($konek,$sql_cek);
    $res = array();
    while($row = mysqli_fetch_assoc($result_cek)){
        $res[]=$row;
    }
    echo($result_cek) ?
        json_encode(array('kode' =>200,'result_login'=>$res)) :
        json_encode(array('kode' =>204,'result_login' =>'Data tidak ditemukan'));