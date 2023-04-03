package Structur;

//import Structur.Vector3d;

public class Rib3d {

	// переменные отвечающие за края отрезка
	private Vector3d _a;
	private Vector3d _b;
	
	//поучение переменых
	public Vector3d a(){
		return _a; 
	}
	public Vector3d b(){
		return _b; 
	}
	
	// изменение переменных
	public void a(Vector3d a){
		this._a = a;
	}
	public void b(Vector3d b){
		this._b = b;
	}
	
	// конструктор с 6 аргументами (3 координаты первой точки и 3 координаты второй точки)
	public Rib3d (double x1, double y1, double z1,double x2, double y2, double z2){
		this._a = new Vector3d(x1,y1,z1);
	    this._b = new Vector3d(x2,y2,z2);
	}
	
	// конструктор с 4 аргументами (данные первой точки и 3 координаты второй точки)
	public Rib3d (Vector3d x1,double x2, double y2, double z2){
		this._a = x1;
	    this._b = new Vector3d(x2,y2,z2);
	}
	
	// конструктор с 4 аргументами (3 координаты первой точки и данные второй точки)
	public Rib3d (double x1, double y1, double z1,Vector3d x2){
		this._a = new Vector3d(x1,y1,z1);
	    this._b = x2;
	}
	
	// конструктор с 2 аргументами (данные первой точки и данные второй точки)
	public Rib3d (Vector3d x1,Vector3d x2){
		this._a = x1;
	    this._b = x2;
	}
	
	// функция для нахождения середины отрезка
	public Vector3d center (Rib3d rib) {
		return new Vector3d ((rib.a().x()+rib.b().x())/2,(rib.a().y()+rib.b().y())/2,(rib.a().z()+rib.b().z())/2);
	}
	
	//Функция для вычисления длины отрезка
	public static double length (Rib3d rib) {
		return Math.sqrt(Math.pow(rib.a().x()-rib.b().x(),2)+Math.pow(rib.a().y()-rib.b().y(),2)+Math.pow(rib.a().y()-rib.b().y(),2)) ; 
	}	
	
}
