package id.rata.testrata.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PembayaranDto {

	private Integer idPembayaran;
	private Integer idPesanan;
	private String noInvoice;
	private String metodePembayaran;
	private String buktiPembayaran;
	private String statusPembayaran;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date tanggalPembayaran;
	
}
