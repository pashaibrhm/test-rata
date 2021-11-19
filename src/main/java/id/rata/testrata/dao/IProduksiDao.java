package id.rata.testrata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.rata.testrata.entity.Produksi;

public interface IProduksiDao extends JpaRepository<Produksi, Integer> {

	@Query(value = "SELECT prdk.id_produksi, ordr.no_invoice, "
			+ "CASE WHEN prdk.status_produksi = 1 "
			+ "THEN 'Desain' WHEN prdk.status_produksi = 2 "
			+ "THEN 'Konfirmasi' WHEN prdk.status_produksi = 3 "
			+ "THEN 'Cetak' WHEN prdk.status_produksi = 4 "
			+ "THEN 'Siap' WHEN prdk.status_produksi = 5 "
			+ "THEN 'Kirim' WHEN prdk.status_produksi = 6 "
			+ "THEN 'Sampai' ELSE '-' END status_produksi, "
			+ "prdk.catatan_produksi, prdk.tanggal_masuk, prdk.tanggal_produksi, prdk.tanggal_selesai "
			+ "FROM tbl_produksi prdk JOIN tbl_pesanan ordr ON prdk.id_pesanan = ordr.id_pesanan", nativeQuery = true)
	List<Object[]> findAllProduksi();
	
	@Query(value = "SELECT prdk.* FROM tbl_produksi prdk WHERE prdk.id_pesanan = :idPesanan", nativeQuery = true)
	Produksi getProduksiByIdPesanan(@Param("idPesanan") Integer idPesanan);
}
