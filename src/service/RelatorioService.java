
package service;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import dao.Conexao;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JRException;

public class RelatorioService
{
	public void gerarRelatorioAtualizado(String caminhoJrxml, String caminhoPdf)
	        throws JRException, IOException, SQLException {

	    InputStream jrxmlStream = getClass().getResourceAsStream(caminhoJrxml);
	    if (jrxmlStream == null) {
	        throw new JRException("Arquivo .jrxml não encontrado no classpath: " + caminhoJrxml);
	    }

	    Map<String, Object> parametros = new HashMap<>();

	    try (InputStream in = jrxmlStream; Connection conn = Conexao.getConnection()) {
	        JasperReport report = JasperCompileManager.compileReport(in);
	        JasperPrint print = JasperFillManager.fillReport(report, parametros, conn);

	        JasperViewer viewer = new JasperViewer(print, false);
	        viewer.setVisible(true);

	        if (caminhoPdf != null && !caminhoPdf.isBlank()) {
	            File pdfFile = new File(caminhoPdf);
	            if (pdfFile.exists()) {
	                pdfFile.delete();
	            }
	            JasperExportManager.exportReportToPdfFile(print, caminhoPdf);

	            if (pdfFile.exists() && Desktop.isDesktopSupported()) {
	                Desktop.getDesktop().open(pdfFile);
	            }
	        }
	    }
	}}
