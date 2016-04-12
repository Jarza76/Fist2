
Function hall_of_fame()
	uusi_tulos = pisteet1
	;global lista$ = "fame.dat"  	; tiedoston nimi
	;Global a = 0, vali = 0, uuden_paikka
	;Global listan_pituus = 20 		; listan pituus
	;Dim tulokset(listan_pituus+1,1)	; taulukko, johon tulokset
	;Dim nimet$(listan_pituus+1,2)		; taulukko, johon nimet luetaan
	;Global tallenna_uusi

	lue_lista()
	nayta_lista()
	Cls
	DrawImage title,0,0
	nayta_lista()
	Flip
	Delay 1000
	FlushKeys()
	WaitKey()

End Function

Function lue_lista()
	filein = ReadFile(lista$) 				;avataan tiedosto lukemista varten
	While (Not Eof(filein)) And (a <= listan_pituus);Luetaan tiedostoa kunnes se loppuu.
		tulokset(a,0) = ReadInt(filein)			;Vuoron perään luetaan numero,
		nimet$(a,0) = ReadString(filein)			;nimi,
		nimet$(a,1) = ReadString(filein)			;ja level tms. arvo

		If (uusi_tulos <= tulokset(a,0)) Then uuden_paikka = a + 1 ;verrataan uutta tulosta listan tuloksiin

		a = a + 1	
	Wend
	CloseFile(filein)				;Suljetaan luettava tiedosto.
	If (uuden_paikka > listan_pituus) Then 
		tallenna_uusi = 0 ;katsotaan pääsikö listalle, jos ei niin nollataan
	Else
		tallenna_uusi = 1
	EndIf
End Function


Function nayta_lista()
	a = 0 : vali = 100
	While (a < listan_pituus)
		a = a + 1
		vali = vali + 15
		
		If (tallenna_uusi = 1) Then 
			If (a = uuden_paikka) Then vali = vali + 15
		EndIf
		Color 255,255,255
		If (a >= uuden_paikka And tallenna_uusi = 1) Then
			If( a < listan_pituus) Then
				Text 200,vali, a+1 +"  "+(nimet$(a,0) + "  " + tulokset(a,0) + "  " + "  " + nimet$(a,1))				
			EndIf
		Else
			Text 200,vali, a +"  "+(nimet$(a,0) + "  " + tulokset(a,0) + "  " + "  " + nimet$(a,1))				
		EndIf
	Wend

	;tallennetaan uusi tulos jos tallenna_uusi on 1
	If (tallenna_uusi = 1 ) Then
		a = listan_pituus
		While (a > 0)
			If (a >= uuden_paikka) Then 
				tulokset(a,0) = tulokset(a-1,0)
				nimet$(a,0) = nimet$(a-1,0)
				nimet$(a,1) = nimet$(a-1,1)
			EndIf
			
			If (a = uuden_paikka) Then
				tulokset(a,0) = uusi_tulos
				;Locate 100,uuden_paikka * 15
				Color 0,0,255
				Cls
				DrawImage title,0,0
				Flip
				nimet$(a,0) = Input("Please enter your name: ")
				nimet$(a,1) = ""
			EndIf
		a = a - 1			
		Wend
		
		fileout = WriteFile(lista$)					;Avataan tiedosto kirjoittamista varten
		For a = 0 To listan_pituus+1
			WriteInt(fileout, tulokset(a,0))		;pisteet
			WriteString(fileout, nimet$(a,0))		;nimi
			WriteString(fileout, nimet$(a,1))		;level
		Next
		
		tallenna_uusi = 0
	EndIf
End Function	



Function uusi_lista()
	fileout = WriteFile(lista$)	 ;Avataan tiedosto
	For a = 0 To listan_pituus	 ;Luodaan listan_pituus -määrä tietueita
		WriteInt(fileout, 0)	 ;pisteet
		WriteString(fileout, " ");nimi
		WriteString(fileout, " ");level tms. arvo
	Next
	CloseFile(fileout)			 ;Suljetaan tiedosto.
End Function