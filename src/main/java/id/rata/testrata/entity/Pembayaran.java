package id.rata.testrata.entity;

import java.util.Date;

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
@Table(name = "tbl_pembayaran")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pembayaran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pembayaran")
	private Integer idPembayaran;
	
	@Column(name = "id_pesanan")
	private Integer idPesanan;
	
	@Column(name = "bukti_pembayaran")
	private String buktiPembayaran;
	
	@Column(name = "metode_pembayaran")
	private Integer metodePembayaran;
	
	@Column(name = "status_pembayaran")
	private Integer statusPembayaran;
	
	@Column(name = "tanggal_pembayaran")
	private Date tanggalPembayaran;
}
