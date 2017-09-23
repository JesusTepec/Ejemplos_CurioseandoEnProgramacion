
TAM_MAX_CLAVE = 26

def menuPrincipal():
	while True:
		print("================================== ")
		print("========= CIFRADO CESAR ========== ")
		print("================================== ")
		print("== a) Cifrar                    == ")
		print("== b) Decifrar                  == ")
		print("== c) Decifrar por fuerza bruta == ")
		print("== x) Salir                     == ")
		print("================================== ")
		opcion = input().lower();
		if opcion in "a,b,c,x".split(','):
			return opcion

def obtenerMensaje():
	print('Ingresa tu mensaje:')
	return input()

def obtenerClave():
    clave = 0
    while True:
    	print('Ingresa el número de clave (1-%s)' % (TAM_MAX_CLAVE))
    	clave = int(input())
    	if(clave >= 1 and clave <= TAM_MAX_CLAVE):
    		return clave

def traducirMensaje(opcion, mensaje, clave):
	if opcion == 'b':
		clave = -clave
	traduccion = ''

	for simbolo in mensaje:
		if simbolo.isalpha():
			num = ord(simbolo)
			num += clave

			if simbolo.isupper():
				if num > ord('Z'):
					num -= 26
				elif num < ord('A'):
					num += 26
			elif simbolo.islower():
				if num > ord('z'):
					num -= 26
				elif num < ord('a'):
					num += 26
			traduccion += chr(num)
		else:
			traduccion += simbolo
	return traduccion

def main():
	while True:
		opcion = menuPrincipal()
		if opcion == 'x':
			break
		mensaje = obtenerMensaje()
		if opcion == 'c':
			print('Tu texto traducido es:')
			for clave in range(1, TAM_MAX_CLAVE):
				print(clave + ':' ,traducirMensaje(opcion, mensaje, clave));
		else:
			clave = obtenerClave()
			print('Tu texto traducido es:')
			print(traducirMensaje(opcion, mensaje, clave));

if __name__ == "__main__":
	main()
