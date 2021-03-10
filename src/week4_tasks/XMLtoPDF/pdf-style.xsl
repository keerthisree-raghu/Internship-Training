<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:template match="invoice">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4"
					page-height="29.7cm" page-width="21cm" margin-top="2cm"
					margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="12pt" font-weight="bold"
						space-after="5mm">
						Invoice Number:
						<xsl:value-of select="invoiceNo" />
					</fo:block>
					<fo:block font-size="12pt" font-weight="bold"
						space-after="5mm">
						Invoice Date:
						<xsl:value-of select="invoiceDate" />
					</fo:block>
					<fo:block font-size="12pt" font-weight="bold"
						space-after="5mm">
						Customer Name:
						<xsl:value-of select="customerName" />
					</fo:block>
					<fo:block font-size="11pt">
						<fo:table table-layout="fixed" width="100%"
							border-collapse="separate">
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-header>
								<fo:table-cell>
									<fo:block font-weight="bold">Item Number</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-weight="bold">Item Name</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-weight="bold">Item Price</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-weight="bold">Quantity</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-weight="bold">Amount</fo:block>
								</fo:table-cell>
							</fo:table-header>
							<fo:table-body>
								<xsl:apply-templates select="items" />
							</fo:table-body>
						</fo:table>
					</fo:block>
					<fo:block font-size="11pt"
						space-before="5mm"
						space-after="5mm">
						GST:
						<xsl:value-of select="gst" />
					</fo:block>
					<fo:block font-size="11pt"
						space-after="5mm">
						Net Total:
						<xsl:value-of select="netTotal" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="item">
		<fo:table-row>
			<!-- <xsl:if test="designation = 'Manager'"> <xsl:attribute name="font-weight">bold</xsl:attribute> 
				</xsl:if> -->
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="itemNo" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="itemName" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="itemPrice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="quantity" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="amount" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>