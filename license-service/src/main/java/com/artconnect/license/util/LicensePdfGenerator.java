package com.artconnect.license.util;

import java.io.ByteArrayOutputStream;

import com.artconnect.license.entity.License;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class LicensePdfGenerator {

    public static byte[] generate(License license) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("ArtConnect License Certificate"));
            document.add(new Paragraph("License ID: " + license.getId()));
            document.add(new Paragraph("Artist ID: " + license.getArtistId()));
            document.add(new Paragraph("Artwork ID: " + license.getArtworkId()));
            document.add(new Paragraph("Type: " + license.getLicenseType()));
            document.add(new Paragraph("Status: " + license.getStatus()));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}