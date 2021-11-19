package id.rata.testrata.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_barang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Barang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_barang")
	private Integer idBarang;
	
	@Column(name = "kode_barang")
	private String kodeBarang;
	
	@Column(name = "nama_barang")
	private String namaBarang;
	
	@Column(name = "harga_barang")
	private BigDecimal hargaBarang;

}
