<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:template match="Invoice">
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
						<xsl:value-of select="InvoiceNumber" />
					</fo:block>
					<fo:block font-size="12pt" font-weight="bold"
						space-after="5mm">
						Invoice Date:
						<xsl:value-of select="InvoiceDate" />
					</fo:block>
					<fo:block font-size="12pt" font-weight="bold"
						space-after="5mm">
						Customer ID:
						<xsl:value-of select="CustomerID" />
					</fo:block>
					<fo:block font-size="12pt" font-weight="bold"
						space-after="5mm">
						Customer Name:
						<xsl:value-of select="CustomerName" />
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
								<xsl:apply-templates select="Items" />
							</fo:table-body>
						</fo:table>
					</fo:block>
					<fo:block font-size="11pt" space-before="5mm"
						space-after="5mm">
						GST:
						<xsl:value-of select="GST" />
					</fo:block>
					<fo:block font-size="11pt" space-after="5mm">
						Net Total:
						<xsl:value-of select="Total" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="item">
		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="ItemNo" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="ItemName" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="ItemPrice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="Quantity" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="Amount" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>