<?php
	require_once 'koneksi.php';
	if($_SERVER['REQUEST_METHOD'] == 'POST') {
		$username = $_POST['username'];
        $password = $_POST['pass'];
        $nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
        $no_telp = $_POST['no_telp'];
        
		$query = "INSERT INTO costumer_(username, pass, nama, alamat, no_telp) 
		VALUES('".$username."','".$password."','".$nama."','".$alamat."','".$no_telp."');";
		$exeQuery = mysqli_query($konek, $query);
		echo ($exeQuery) ? 
		json_encode(array('kode' => 201,'pesan' => 'sukses register')) : 
		json_encode(array('kode' => 500,'pesan' => 'gagal register'));
	} else {
		echo json_encode(array('kode' => 11, 'pesan' => 'request tidak valid'));
	}
?>