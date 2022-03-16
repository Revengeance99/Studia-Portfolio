	;50H adres pierwszej liczby		
	;52H adres drugiej liczby
	AD1	EQU	40H
	
	TEKST1	EQU	4050H
	
	
	LJMP	START			
	ORG	100H			
START:					
	
	MOV	A, #'x'		;Przenie� "x" do A
	LCALL 	WRITE_DATA	;Wy�wietl "x" na wy�wietlaczu
	MOV	A, #'='		;Przenie� "=" do A
	LCALL	WRITE_DATA	;Wy�wietl "=" na wy�wietlaczu
	MOV	R0, #50h	;Adres 1 liczby do R0
	LCALL	GET_NUM		;Pobierz cyfry z klawiatury i wy�wietla
	ACALL	H		;Wykonaj funkcj� "H"
	ACALL	SPACE		;Wykonaj funkcj� "SPACE"
	MOV	A, #'y'		;Przenie� "y" do A
	LCALL 	WRITE_DATA	;Wy�wietl "y" na wy�wietlaczu
	MOV	A, #'='		;Przenie� "=" do A
	LCALL	WRITE_DATA	;Wy�wietl "=" na wy�wietlaczu
	MOV	R0, #52h		;Adres 2 liczby do R0
	LCALL	GET_NUM		;Pobierz cyfry z klawiatury
	ACALL	H		
	ACALL	SPACE		
	MOV	R2, #4
	MOV	DPTR, #TEKST1
	ACALL	TEXT_L
	LCALL	WAIT_KEY	;Czekaj na klawisz
	LCALL 	LCD_CLR		;Czy�� wy�wietlacz
	MOV	A, #'x'		;Dodaj "x" do A
	LCALL 	WRITE_DATA	;Wy�wietl "x" na wy�wietlaczu
	ACALL	SPACE		
	MOV	A, #'+'		;Dodaj "+" do A
	LCALL 	WRITE_DATA	;Wy�wietl "+" na wy�wietlaczu
	ACALL	SPACE		
	MOV	A, #'y'		;Dodaj "y" do A
	LCALL 	WRITE_DATA	;Wy�wietl "y" na wy�wietlaczu
	ACALL	SPACE		
	MOV	A, #'='		;Dodaj "=" do A
	LCALL 	WRITE_DATA	;Wy�wietl "=" na wy�wietlaczu
	ACALL	SPACE		
	ACALL	DOD		;Wykonaj funkcj� "DOD"
	ACALL	SPACE
	ACALL	SPACE
	ACALL	SPACE	
	ACALL	SPACE
	MOV	A, #'x'		
	LCALL 	WRITE_DATA	
	ACALL	SPACE		
	MOV	A, #'-'		
	LCALL 	WRITE_DATA	
	ACALL	SPACE		
	MOV	A, #'y'		
	LCALL 	WRITE_DATA	
	ACALL	SPACE		
	MOV	A, #'='		
	LCALL 	WRITE_DATA	
	;ACALL	SPACE		
	ACALL 	ODE
	MOV	R2, #4
	MOV	DPTR, #TEKST1
	ACALL	TEXT_L			
	LCALL	WAIT_KEY	;Czekaj na dowolny klawisz
	LCALL	LCD_CLR		
	LJMP	START		;Skocz na pocz�tek
H:
	MOV 	A, #'h'		;Przenie� "h" do A
	LCALL	WRITE_DATA	;Wy�wietl "h" na wy�wietlaczu
	RET			;Wyjd� z funkcji
	
SPACE:
	MOV	A,#32		;Przenie� znak spacji do A
	LCALL	WRITE_DATA	;Wy�wietl znak spacji
	RET			;Wyjd� z funkcji

DOD:
	CLR	C
	MOV	A, 50h		;Warto�� 1 liczby do A
	MOV	R0, 52h		;Warto�� 2 liczby do R0
	MOV	B, R0		;Warto�� R0 do B
	ADD	A, B		;Dodaj B do A
	MOV	AD1,A
	JNC	EE
	MOV	A, #'1'		
	LCALL	WRITE_DATA
	AJMP	EE1
EE:	ACALL	SPACE
EE1:	MOV	A,AD1
	LCALL	WRITE_HEX
	ACALL	H				
	RET			

ODE:
	MOV	A, 50h		;Warto�� 1 liczby do A
	CLR	C		;Zeruj bit CY
	SUBB	A, 52h		
	JNC	ODEPLUS		
	CPL	A		
	ADD	A, #01h		
	MOV	R0, A		
	MOV	A, #'-'		
	LCALL	WRITE_DATA	
	ACALL	ODEPLUS		
	RET			

ODEPLUS:
	LCALL	WRITE_HEX	
	ACALL	H		
	ACALL	SPACE		
	RET
			
TEXT_L:
	MOVX	A,@DPTR
	INC	DPTR
	LCALL	WRITE_DATA
	DJNZ	R2,TEXT_L
	RET

	ORG	TEKST1
	DB	"klik"


END				
	
	

	