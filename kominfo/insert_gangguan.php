<?php
	require_once 'koneksi.php';
	if($_SERVER['REQUEST_METHOD'] == 'POST') {
		$keterangan = $_POST['keterangan'];
        
		$query = "INSERT INTO gangguan(keterangan) VALUES('".$keterangan."');";
		$exeQuery = mysqli_query($konek, $query);
		echo ($exeQuery) ? 
		json_encode(array('kode' => 201,'pesan' => 'sukses kirim gangguan')) : 
		json_encode(array('kode' => 500,'pesan' => 'gagal kirim gangguan'));
	} else {
		echo json_encode(array('kode' => 11, 'pesan' => 'request tidak valid'));
	}
?>