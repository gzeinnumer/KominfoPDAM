<?php
	require_once 'koneksi.php';
    $sql_cek = "SELECT * FROM bill_ ;";
    $result_cek = mysqli_query($konek,$sql_cek);
    $res = array();
    while($row = mysqli_fetch_assoc($result_cek)){
        $res[]=$row;
    }
    echo($result_cek) ?
    json_encode(array('kode' =>1,'result_bill'=>$res)) :
    json_encode(array('kode' =>2,'result_bill' =>'Data tidak ditemukan'));