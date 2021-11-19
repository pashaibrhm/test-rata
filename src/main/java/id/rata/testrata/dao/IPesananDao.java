package id.rata.testrata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.rata.testrata.entity.Pesanan;

public interface IPesananDao extends JpaRepository<Pesanan, Integer>{

	@Query(value="SELECT ordr.id_pesanan, ordr.no_invoice, ordr.kode_barang, brng.nama_barang, "
			+ "ordr.jumlah_pesanan, (ordr.jumlah_pesanan * brng.harga_barang) total_pesanan, "
			+ "ordr.tanggal_pesanan, ordr.nama_pemesan, ordr.alamat_pemesan "
			+ "FROM tbl_pesanan ordr "
			+ "JOIN tbl_barang brng "
			+ "ON ordr.kode_barang = brng.kode_barang", nativeQuery = true)
	List<Object[]> findAllPesanan();
	
	@Query(value="SELECT ordr.* FROM tbl_pesanan ordr WHERE ordr.no_invoice = :noInvoice", nativeQuery = true)
	Pesanan findPesananByNoInvoice(@Param("noInvoice")String noInvoice);
}
