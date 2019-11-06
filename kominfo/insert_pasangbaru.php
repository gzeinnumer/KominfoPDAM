<?php
	require_once 'koneksi.php';
	if($_SERVER['REQUEST_METHOD'] == 'POST') {
		$nama = $_POST['nama'];
        $alamat = $_POST['alamat'];
        $no_telp = $_POST['no_telp'];
        
		$query = "INSERT INTO pasanglayanan(nama, alamat, no_telp) VALUES('".$nama."','".$alamat."','".$no_telp."');";
		$exeQuery = mysqli_query($konek, $query);
		echo ($exeQuery) ? 
		json_encode(array('kode' => 201,'pesan' => 'sukses tambah data')) : 
		json_encode(array('kode' => 500,'pesan' => 'gagal tambah data'));
	} else {
		echo json_encode(array('kode' => 11, 'pesan' => 'request tidak valid'));
	}
?>