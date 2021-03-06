	AD1	EQU	40H
	AD2	EQU	41H
	AD3	EQU	42H	;pomocniczy przy dodawaniu

	TEKST1	EQU	4050H
	TEKST2	EQU	4100H

	LJMP	START
	ORG	100H
START:
	ACALL 	KLIKNIJ4
	ACALL	SPACE
	ACALL	READ_HEX
	MOV	AD1, A
	LCALL	WRITE_HEX
	ACALL	H
	ACALL	SPACE
	ACALL 	READ_HEX
	MOV	AD2, A
	LCALL	WRITE_HEX
	ACALL	H
	ACALL	SPACE
	ACALL	KLIKNIJ
	LCALL	WAIT_KEY
	LCALL	LCD_CLR


;===============DODAWANIE===========
	ACALL	FZMIENNA
	MOV	A, #'+'
	LCALL	WRITE_DATA
	ACALL	SZMIENNA
	ACALL	EQUAL
; zmiany od
	CLR	C		;przy dodawaniu wynik mo?e by? wi?kszy od 255 i powstaje w?wczas CY=1
	MOV	A, AD1
	ADD	A, AD2
	MOV	AD3, A		;chowamy m?odsz? cz??? wyniku
	JNC	EE		;wynik mniejszy r?wny 255
	MOV	A, #'1'
	LCALL	WRITE_DATA
	AJMP	EE1
EE:	ACALL	SPACE		;wydruk spacji bo wynik bedzie 2-u cyfrowy	
EE1:	MOV	A, AD3		;przywo?ujemy m?odsz? cz?? sumy
; zmiany do
	LCALL	WRITE_HEX
	ACALL	H
	ACALL	SPACE
	ACALL	SPACE
	ACALL	SPACE
	ACALL	SPACE
;	ACALL	SPACE		zbedna spacja bo wynik jest zawsze 3-y cyfrowy
	
	

;ODEJMOWANIE

	ACALL 	FZMIENNA
	MOV	A, #'-'
	LCALL	WRITE_DATA
	ACALL	SZMIENNA
	ACALL	EQUAL
	MOV 	A, AD1
	CLR	C
	SUBB	A, AD2
	JNC	ODE
	CPL	A
	ADD	A, #01H
	MOV	R0, A
	MOV	A, #'-'
	LCALL	WRITE_DATA
	MOV	A, R0
	LCALL	WRITE_HEX
	ACALL	H
	LCALL	WAIT_KEY
	ACALL	SPACE
	ACALL	SPACE
	ACALL	SPACE
	ACALL	SPACE
	LCALL	LCD_CLR
	
	
MLP:	
	
		
;MNO?ENIE	

	ACALL	FZMIENNA
	MOV	A, #'*'
	LCALL	WRITE_DATA
	ACALL	SZMIENNA
	ACALL	EQUAL
	MOV	A, AD1
	MOV	B, A
	MOV	A, AD2
	MUL	AB
	MOV	R1, A
	MOV	A, B
	LCALL	WRITE_HEX
	MOV	A, R1
	LCALL	WRITE_HEX
	ACALL	H
	ACALL	SPACE
	ACALL	SPACE
	ACALL	SPACE

	
;DZIELENIE
	ACALL	FZMIENNA
	MOV	A, #':'
	LCALL	WRITE_DATA
	ACALL	SZMIENNA
	ACALL	EQUAL
	MOV	A, AD2
	MOV	B, A
	MOV	A, AD1
	DIV	AB		;cz??? ca?kowita w A, reszta w B
	MOV	R0, B
	LCALL	WRITE_HEX
	ACALL	H
	MOV	A, R0
	JZ	RESZTA_ZERO
	ACALL	SPACE
	MOV	A, #'r'
	LCALL	WRITE_DATA
; poprawki
	MOV	A, R0
	LCALL	WRITE_HEX

;	MOV	A, #'0'		;tutaj reszta jest r??na od zera
;	LCALL	WRITE_DATA
	ACALL	H

RESZTA_ZERO:
	LCALL	WAIT_KEY
	LCALL	LCD_CLR
	LJMP	START

;==============FUNKCJE==================
ODE:
	LCALL	WRITE_HEX
	ACALL	H
	LCALL	WAIT_KEY
	LCALL	LCD_CLR
	LJMP 	MLP
	
EQUAL:
	MOV	A,#'='
	LCALL	WRITE_DATA
	RET

FZMIENNA:
	MOV	A, AD1
	LCALL	WRITE_HEX
	ACALL	H
	RET
SZMIENNA:
	MOV	A, AD2
	LCALL	WRITE_HEX
	ACALL	H
	RET

H:
	MOV	A, #'h'
	LCALL	WRITE_DATA
	RET
KLIKNIJ:
	MOV	R2, #7
	MOV	DPTR, #TEKST1
	ACALL	TEXT_L
	RET
KLIKNIJ4:
	MOV	R2,#15
	MOV	DPTR, #TEKST2
	ACALL	TEXT_L
	RET
	
	
SPACE:
	MOV	A, #32
	LCALL	WRITE_DATA
	RET

READ_HEX:
	LCALL	WAIT_KEY
	SWAP	A
	MOV	B, A
	LCALL	WAIT_KEY
	ORL	A, B
	RET
TEXT_L:
	MOVX	A,@DPTR
	INC	DPTR
	LCALL	WRITE_DATA
	DJNZ	R2,TEXT_L
	RET

	ORG	TEKST1
	DB	"kliknij"
	ORG	TEKST2
	DB	"kliknij 4 znaki"
END
	
	
