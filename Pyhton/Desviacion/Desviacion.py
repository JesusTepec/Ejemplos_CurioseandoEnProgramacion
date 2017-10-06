import math

def menu():
	print ()
	print ("1) Ingresar datos")
	print ("2) Calcular varianza")
	print ("3) Calcular desviación")
	print ("4) Salir")

def obtenerDatos():
	print ("Digite cuantos datos desea ingresar?")
	numeroDatos = int(input())
	datos = []
	for i in range(0, numeroDatos):
		print ("Ingrese dato ", i + 1)
		dato = input()
		datos.append(int(dato))
	return datos

def obtenerPromedio(datos):
	suma = 0
	for dato in datos:
		suma += dato
	return suma / len(datos)

def obtenerVarianza(datos):
	n = len(datos)
	promedio = obtenerPromedio(datos)
	varianza = 0
	for dato in datos:
		varianza += math.pow((dato - promedio), 2)
	return varianza / (n - 1)

def obtenerDesviacion(varianza, datos):
	if(varianza == 0):
		varianza = obtenerVarianza(datos)
		return math.sqrt(varianza)
	elif(varianza > 0):
		return math.sqrt(varianza)

def main():
	salir = False
	datos = []
	varianza = 0
	while not salir:
		opcion = -1
		menu()
		opcion = input()
		if(opcion == '1'):
			datos = obtenerDatos()
		elif(opcion == '2'):
			varianza = obtenerVarianza(datos)
			print ("Valor de varianza: ", varianza)
			input("Enter para continuar...")
		elif(opcion == '3'):
			desviasion = obtenerDesviacion(varianza, datos)
			print ("Valor de Desviacion estandar: ", desviasion)
			input("Enter para continuar...")
		elif(opcion == '4'):
			salir = True
		else:
			print ("No existe opción")

if __name__ == "__main__":
	main()
