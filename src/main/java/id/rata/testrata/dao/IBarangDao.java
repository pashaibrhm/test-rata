package id.rata.testrata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.rata.testrata.entity.Barang;

public interface IBarangDao extends JpaRepository<Barang, Integer>{

	@Query(value="SELECT brng.* FROM tbl_barang brng WHERE brng.kode_barang = :kodeBarang", nativeQuery = true)
	Barang findBarangByKodeBarang(@Param("kodeBarang")String kodeBarang);
}
