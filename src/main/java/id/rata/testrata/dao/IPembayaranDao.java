package id.rata.testrata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.rata.testrata.entity.Pembayaran;


public interface IPembayaranDao extends JpaRepository<Pembayaran, Integer> {
	
	@Query(value="SELECT COALESCE (ordr.no_invoice, '-') no_invoice, "
			+ "CASE "
				+ "WHEN pymt.metode_pembayaran = 1 THEN 'Transfer' "
				+ "WHEN pymt.metode_pembayaran = 2 THEN 'CC' "
				+ "WHEN pymt.metode_pembayaran = 3 THEN 'Shopee' "
				+ "WHEN pymt.metode_pembayaran = 4 THEN 'Tokopedia' "
				+ "ELSE '-' "
			+ "END metode_pembayaran, "
			+ "COALESCE (pymt.bukti_pembayaran, '-') bukti_pembayaran, "
			+ "CASE "
				+ "WHEN pymt.status_pembayaran = 1 THEN 'Pending' "
				+ "WHEN pymt.status_pembayaran = 2 THEN 'Lunas' "
				+ "WHEN pymt.status_pembayaran = 3 THEN 'Batal' "
				+ "ELSE '-' "
			+ "END status_pembayaran, "
			+ "pymt.tanggal_pembayaran "
			+ "FROM tbl_pembayaran pymt JOIN tbl_pesanan ordr ON pymt.id_pesanan = ordr.id_pesanan", nativeQuery = true)
	List<Object[]> findAllPembayaran();
}
