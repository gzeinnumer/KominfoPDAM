<?php
	require_once 'koneksi.php';
	if($_SERVER['REQUEST_METHOD'] == 'POST') {
		$username = $_POST['username'];
        $password = $_POST['pass'];
        $id_emp = $_POST['id_emp'];
        
		$query = "INSERT INTO users_(username, pass, id_emp) VALUES('".$username."','".$password."','".$id_emp."');";
		$exeQuery = mysqli_query($konek, $query);
		echo ($exeQuery) ? 
		json_encode(array('kode' => 201,'pesan' => 'sukses register')) : 
		json_encode(array('kode' => 500,'pesan' => 'gagal register'));
	} else {
		echo json_encode(array('kode' => 11, 'pesan' => 'request tidak valid'));
	}
?>