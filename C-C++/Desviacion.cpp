#include <iostream>
#include "math.h"
#include "conio.h"

using namespace std;

void menu(){
  cout << "1) Ingresar datos" << '\n';
  cout << "2) Calcular varianza" << '\n';
  cout << "3) Calcular desviación" << '\n';
  cout << "4) Salir" << '\n';
}

int numeroDatos(){
  int cantidad = 0;
  cout << "Número de datos a ingresar:" << '\n';
  cin >> cantidad;
  return cantidad;
}

int * obtenerDatos(int cantidad){
  int * datos = new int[cantidad];
  for (size_t i = 0; i < cantidad; i++) {
    std::cout << "Ingrese dato " <<i+1 <<": " << '\n';
    cin >> datos[i];
  }
  return datos;
}

float obtener_promedio(int cantidad, int *datos){
  float suma = 0;
  for (size_t i = 0; i < cantidad; i++) {
    suma += datos[i];
  }
  return suma / cantidad;
}

float obtener_varianza(int cantidad, int *datos){
  int n = cantidad;
  float promedio = obtener_promedio(n, datos);
  float varianza = 0;
  for (size_t i = 0; i < n; i++) {
    varianza += pow((datos[i] - promedio), 2.0);
  }
  return varianza / (n -1);
}

float obtener_desviacion(int cantidad, float varianza, int *datos){
  if(varianza == 0){
    float varianza = obtener_varianza(cantidad, datos);
  }
  return sqrt(varianza);
}

int  main(int argc, char const *argv[]) {
  int opcion = -1;
  int cantidad = 0;
  int *datos;
  float varianza = 0;
  float desviacion = 0;
  char pause = 0;
  do{
    menu();
    cin >> opcion;
    if(cin.fail() && cin.rdstate()){
         cout << "NO ES UN NUMERO" << endl;
         opcion = -1;
    }
    switch (opcion) {
      case 1:
          cantidad = numeroDatos();
          datos = obtenerDatos(cantidad);
          break;
      case 2:
          varianza = obtener_varianza(cantidad, datos);
          cout << "varianza: " << varianza << '\n';
          cout << "continuar..." << endl;
          getch();
          break;
      case 3:
          desviacion = obtener_desviacion(cantidad, varianza, datos);
          cout << "Desviación: " << desviacion << '\n';
          cout << "continuar..." << endl;
          getch();
          break;
      default:
        cout << "No existe opción" << '\n';
        break;
    }

  } while (opcion != 4);
  return 0;
}
