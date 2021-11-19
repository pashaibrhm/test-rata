package id.rata.testrata.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduksiDto {

	private Integer idProduksi;
	private String noInvoice;
	private String statusProduksi;
	private Date tanggalMasuk;
	private Date tanggalProduksi;
	private Date tanggalSelesai;
}
