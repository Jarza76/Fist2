;E X P L O D I N G   F I S T II
;updated 3.8.09
;---------------------------

Graphics 800,600,32,1
SetBuffer BackBuffer()
SeedRnd MilliSecs()

Global title = LoadImage("gfx\fist II.png")

fisk = MilliSecs()

While Not KeyHit(57)
	DrawImage title,10,10
	Flip
	
	If (MilliSecs() > fisk + 10000) Then Exit
Wend


;tuloslistaan
Global a = 0, vali = 0, uuden_paikka
Global listan_pituus = 20 		; listan pituus
Dim tulokset(listan_pituus+1,1)	; taulukko, johon tulokset
Dim nimet$(listan_pituus+1,2)		; taulukko, johon nimet luetaan
Global tallenna_uusi
Global lista$ = "fame.dat"
Global uusi_tulos
;-----------

Global ukko_vasenraja = 99
Global ukko_oikearaja = 600

Global valo_paalle2 = 0
Global valo_paalle3 = 0
Global nulltimer = MilliSecs()
Global nulltimer2 = MilliSecs()
Global aani_paalle3 = 0
;-
;Global fisu = LoadAnimImage("fish_jumping2.png",160,240,0,8)
Global ukko = LoadAnimImage("gfx\walking2.png",100,170,0,4)
Global iskuja = LoadAnimImage("gfx\iskuja2.png",150,170,0,32)
Global iskuja_ts = LoadAnimImage("gfx\iskuja_ts2.png",150,170,0,32)
Global ukko_ts = LoadAnimImage("gfx\walking2_ts.png",100,170,0,4)
Global ukko2 = LoadAnimImage("gfx\walking22.png",100,170,0,4)
Global iskuja2 = LoadAnimImage("gfx\iskuja22.png",150,170,0,32)
Global iskuja_ts2 = LoadAnimImage("gfx\iskuja_ts22.png",150,170,0,32)
Global ukko_ts2 = LoadAnimImage("gfx\walking_ts22.png",100,170,0,4)
Global aloitus2 = LoadAnimImage("gfx\aloitus2.png",100,170,0,2)
Global aloitus = LoadAnimImage("gfx\aloitus.png",100,170,0,2)
Global aloitus3 = LoadAnimImage("gfx\aloitus3.png",100,170,0,2)
Global aloitus3b = LoadAnimImage("gfx\aloitus3b.png",100,170,0,2)
MaskImage aloitus,192,192,192
MaskImage aloitus2,192,192,192
MaskImage aloitus3,0,0,255
MaskImage aloitus3b,0,0,255
Global ukko3 = LoadAnimImage("gfx\walking33.png",100,170,0,4)
Global iskuja3 = LoadAnimImage("gfx\iskuja33.png",150,170,0,32)
Global iskuja_ts3 = LoadAnimImage("gfx\iskuja_ts33.png",150,170,0,32)
Global ukko_ts3 = LoadAnimImage("gfx\walking_ts33.png",100,170,0,4)
MaskImage ukko3,192,192,192
MaskImage iskuja3,192,192,192
MaskImage iskuja_ts3,192,192,192
MaskImage ukko_ts3,192,192,192
Global osuma2_aloitus = 0
Global osuma_aloitus = 0
Global fontti = LoadFont("Arial",18,True,False,False)

Dim nvtaulukko$(80,1) ;nimi&v‰ri -taulukko, 0=nimi, 1=v‰ri;			HALL OF FAMEEN
Dim pistetaulukko(80) ;pistetaulukko

MaskImage ukko,192,192,192
MaskImage ukko_ts,192,192,192
MaskImage iskuja,192,192,192
MaskImage iskuja_ts,192,192,192
MaskImage ukko2,192,192,192
MaskImage ukko_ts2,192,192,192
MaskImage iskuja2,192,192,192
MaskImage iskuja_ts2,192,192,192
Global nilkka_aani = LoadSound("sfx\ankle.wav")
Global mahapotku_aani = LoadSound("sfx\side.wav")
Global ukko_frame = 0
Global isku_frame = 0
Global x = 100, y = 337
Global ukko_timer = MilliSecs()
Global hyppy_timer = MilliSecs()
Global liike_timer = MilliSecs()
Global hyppy_alas_timer = MilliSecs()
Global isku = 0
Global ei_mitaan_timer
Global aloitus_timer
Global ottelu_alkaa = 0
Global aani_paalle = 0
Global suunta = 0 ; 0=oikealle, 1=vasemmalle

ei_mitaan_timer = MilliSecs()
Global n_alas = 80
Global n_ylos = 72
Global kavely_vasen = 75
Global kavely_oikea = 77
Global n_vasen = 75 ; 77
Global n_oikea = 77 ; 75
Global n_oala = 79 ; 79
Global n_vala = 81 ; 81
Global n_oyla = 73; 71
Global n_vyla = 71 ; 73
Global n_control = 157

Global ei_mitaan_timer2 = MilliSecs()
Global suunta2 = 0 ; 0=oikealle, 1=vasemmalle
Global isku2 = 0
Global aani_paalle2 = 0
Global ukko_frame2 = 0
Global isku_frame2 = 0
Global x2 = 500, y2 = 337
Global ukko_timer2 = MilliSecs()
Global hyppy_timer2 = MilliSecs()
Global liike_timer2 = MilliSecs()
Global hyppy_alas_timer2 = MilliSecs()
Global osuu = 0
Global osuu2 = 0
Global osu_xf = 50, osu_xh = 90
Global osu_xfs = 20, osu_xhs = 60
Global osu_xf2 = 50, osu_xh2 = 90
Global osu_xfs2 = 20, osu_xhs2 = 60
Global lights, lights2, lights3
Global valo = LoadImage("gfx\valo.png")
MaskImage valo,0,0,0
Global valo_pois = LoadImage("gfx\valo_pois.png")
MaskImage valo_pois,0,0,0
Global valo_paalle = 0
Global alas_nollaus = 0
Global alas_nollaus2 = 0
Global osuma2 = 0
Global osuma = 0
Global osuma2_timer = MilliSecs()
Global osuma_timer = MilliSecs()
Global osuma2_frame = 0
Global osuma_frame = 0
Global osumat2 = LoadAnimImage("gfx\kaatuminen_2.png",150,120,0,18)
Global osumat = LoadAnimImage("gfx\kaatuminen_1.png",150,120,0,18)
Global osumat3 = LoadAnimImage("gfx\kaatuminen_3.png",150,120,0,18)
MaskImage osumat2,0,0,255
MaskImage osumat,0,0,255
MaskImage osumat3,0,0,255
Global raja = LoadImage("gfx\raja.png")
Global suunnat2
Global suunnat
Global stars_frame = 0
Global stars_frame_timer = MilliSecs()

Global stars = LoadAnimImage("gfx\stars.png",50,20,0,3)
MaskImage stars, 0,0,255


;hall of fameen
;Global scoreglobal
;Global x_sj_list = 57
;Global y_sj_list = 0
;Global kierto = 0
;Global lo = 0
;Global nimiglobal$
;Global etsi
;Global paikkanne

;Include "move_pad.bb"
Include "move_keyb6.bb"
Include "move_cpu6.bb"
Include "move_cpu6c.bb"
Include "move_keyb6_2.bb"
Include "hits_fist.bb"
Include "tuloslista.bb"

Global cpu_timer = MilliSecs()
Global kavely_oikea_cpu = 2
Global kavely_vasen_cpu = 3
Global n_alas_cpu = 4
Global n_ylos_cpu = 5
Global n_vasen_cpu = 6 ; 77
Global n_oikea_cpu = 7 ; 75
Global n_oala_cpu = 8; 79
Global n_vala_cpu = 9 ; 81
Global n_oyla_cpu = 10; 71
Global n_vyla_cpu = 11 ; 73
Global n_control_cpu = 20
Global hyppy_timer_cpu
;---------- CPU 2
Global act2, act4
Global actor2
Global cpu_timer2 = MilliSecs()
Global actwalk2
Global abcde2
Global hyppy_timer_cpu2
Global null_timer2
Global pick_the_man2 = 0, pick2 = MilliSecs(), pause2

Global pisteet1 = 0
Global pisteet2 = 0
Global pisteet3 = 0, p3, p, p2
Global act, act3
Global isku3 = 0
Global isku3_frame = 0
Global ukko3_frame = 0
;---uudet globaalit
Global x3 = 300
Global suunta_c = 0
Global actor = 0
Global abcde, pause, aa, pick_the_man = 0, pick = MilliSecs(), actwalk = 0
Global siirr = 1, siirrys
Global sekunnit, level
Global osuma3 = 0
Global osuma3_timer = MilliSecs()
Global osuma3_frame = 0
Global osuma3_aloitus
Global osuu3 = 0
Global suunnat3
Global alas_nollaus3 = 0
Global osu_xf3 = 50, osu_xh3 = 90
Global osu_xfs3 = 20, osu_xhs3 = 60
Global y3 = 337
Global kello

Global temple1 = LoadImage("gfx\fist II pic 1 - paiva.png")
Global temple2 = LoadImage("gfx\fist II pic 1 - ilta.png")
Global temple3 = LoadImage("gfx\fist II pic 1 - yo.png")
Global river1 = LoadImage("gfx\river_fight - paiva.png")
Global river2 = LoadImage("gfx\river_fight - ilta.png")
Global river3 = LoadImage("gfx\river_fight - yo.png")
Global huts = LoadImage("gfx\village fight - paiva.png")
Global huts2 = LoadImage("gfx\village fight - ilta.png")
Global huts3 = LoadImage("gfx\village fight - yo.png")
Global cave = LoadImage("gfx\cavernous_bongo.png")
Global vesi = LoadImage("gfx\vesi.png")


;------------------
		;If (cpu_vai_ei) = 0 Then;F1 = valkoinen ja vihree
		;If (cpu_vai_ei) = 1 Then;F2 = valkoinen ja punainen
		;If ((cpu_vai_ei) = 3) Then;F4 vain vihre‰ on cpu
		;If ((cpu_vai_ei) = 4) Then;Punainen pelaaja + valkoinen CPU ja vihre‰ CPU
Global cpu_vai_ei = 4
chnbackground = PlayMusic("music\Way_of_the_Exploding_Fist.mp3")
;------------------ M A I N    L O O P ----------------------------------
kalat_x = 320
kalat_Y = 395
kalat_alku = Rand(0,3)
kalat_ajastin = MilliSecs()
freimi_kalat = 0
kalat_on = 0
kalat_out = MilliSecs() + 1000
Global kalat = LoadAnimImage("gfx\fish_jumping2.png",40,40,0,17)
MaskImage kalat,255,255,255



While (Not KeyHit(1))
	Cls

	;If (KeyDown(63)) Then Delay 100 : FlushKeys() : level = level + 1	

	Select level
	Case 1
		DrawImage temple1,0,20
	Case 2
		DrawImage temple2,0,20
	Case 3
		DrawImage temple3,0,20
	Case 4
		DrawImage river1,0,30

		If (kalat_on = 0 And (MilliSecs() > (kalat_out))) Then kalat_on = 1:kalat_ajastin = MilliSecs()
		If (kalat_on) Then
			DrawImage kalat,kalat_x,kalat_y,freimi_kalat
		
			If (MilliSecs() > (kalat_ajastin + 200)) Then
				freimi_kalat = freimi_kalat + 1
				
				If (freimi_kalat > (kalat_alku + 3)) Then
					kalat_on = 0
					kalat_out = (MilliSecs() + Rand(2000,10000))
		
					kalat_x = Rand(100,550)
					kalat_Y = Rand(345,380)
		
					kalat_alku = Rand(0,3)
					Select kalat_alku
					Case 0
						freimi_kalat = 0
					Case 1
						kalat_alku = 4
						freimi_kalat = 4
					Case 2
						kalat_alku = 8
						freimi_kalat = 8
					Case 3
						freimi_kalat = 12
						kalat_alku = 12
				End Select
			EndIf
			kalat_ajastin = MilliSecs()
		EndIf
	EndIf


	Case 5
		DrawImage river2,0,30
		If (kalat_on = 0 And (MilliSecs() > (kalat_out))) Then kalat_on = 1:kalat_ajastin = MilliSecs()
		If (kalat_on) Then
			DrawImage kalat,kalat_x,kalat_y,freimi_kalat
		
			If (MilliSecs() > (kalat_ajastin + 200)) Then
				freimi_kalat = freimi_kalat + 1
				
				If (freimi_kalat > (kalat_alku + 3)) Then
					kalat_on = 0
					kalat_out = (MilliSecs() + Rand(2000,10000))
		
					kalat_x = Rand(100,550)
					kalat_Y = Rand(345,380)
		
					kalat_alku = Rand(0,3)
					Select kalat_alku
					Case 0
						freimi_kalat = 0
					Case 1
						kalat_alku = 4
						freimi_kalat = 4
					Case 2
						kalat_alku = 8
						freimi_kalat = 8
					Case 3
						freimi_kalat = 12
						kalat_alku = 12
				End Select
			EndIf
			kalat_ajastin = MilliSecs()
		EndIf
	EndIf

	Case 6
		DrawImage river3,0,30
		
		If (kalat_on = 0 And (MilliSecs() > (kalat_out))) Then kalat_on = 1:kalat_ajastin = MilliSecs()
		If (kalat_on) Then
			DrawImage kalat,kalat_x,kalat_y,freimi_kalat
		
			If (MilliSecs() > (kalat_ajastin + 200)) Then
				freimi_kalat = freimi_kalat + 1
				
				If (freimi_kalat > (kalat_alku + 3)) Then
					kalat_on = 0
					kalat_out = (MilliSecs() + Rand(2000,10000))
		
					kalat_x = Rand(100,550)
					kalat_Y = Rand(345,380)
		
					kalat_alku = Rand(0,3)
					Select kalat_alku
					Case 0
						freimi_kalat = 0
					Case 1
						kalat_alku = 4
						freimi_kalat = 4
					Case 2
						kalat_alku = 8
						freimi_kalat = 8
					Case 3
						freimi_kalat = 12
						kalat_alku = 12
				End Select
			EndIf
			kalat_ajastin = MilliSecs()
		EndIf
	EndIf

	Case 7
		DrawImage huts,0,20
	Case 8
		DrawImage huts2,0,20
	Case 9
		DrawImage huts3,0,20
	Case 10
		DrawImage cave,0,20	
	Case 11
		DrawImage cave,0,20	
	End Select

	aa = act	;tarvitaan cpu:n ‰‰ni‰ varten
;	move_keyb2()
	move_cpu2()
	move_keyb()
	move_cpu()
	
	hits()
	valot()

	If level > 3 And level < 7 Then DrawImage vesi,0,446
	
	If (act <> aa) Then	;cpu ‰‰net
		If Not (act < 7 Or act > 11) Then PlaySound nilkka_aani
	EndIf

If KeyDown(63) Then siirr = 3

	ajastus()
	Delay 100
	Flip
	If (Not ChannelPlaying(cb)) Then PlayMusic("Way_of_the_Exploding_Fist.mp3")
Wend
;- --------------------------


Function ajastus()
        If (ottelu_alkaa = 0) Then
        	aloitus_timer = MilliSecs()
            ottelu_alkaa = 1
        EndIf
        Color 255,0,0
        Text 415,10,sekunnit
        If (MilliSecs() > aloitus_timer + 2000) Then
        	If (MilliSecs() > kello + 1000) Then
            	kello = MilliSecs()
                sekunnit = sekunnit - 1
            EndIf
        EndIf
End Function