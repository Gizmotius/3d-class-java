package Structur;

public class Vector3d {
	
	// переменные отвечающие за координаты вектора
	private double _x;
	private double _y;
	private double _z;
	
	// конструктор нулевого вектора (по умолчанию)
	public Vector3d(){
		_x=_y=_z=0;
	}
	
	//поучение переменых
	public double x(){
		return _x; 
	}
	public double y(){
		return _y; 
	}
	public double z(){
		return _z; 
	}

	// изменение переменных
	public void x(double x){
		 this._x = x;
	}
	public void y(double y){
		 this._y = y;
	}
	public void z(double z){
		 this._z = z;
	}
	
	
	// конструктор с 3 аргументами
	public Vector3d (double x, double y, double z){
		this._x = x;
        this._y = y;
        this._z = z;
	}
	
	// конструктор который дублирует получаемый вектор
	public Vector3d (Vector3d vec){
		this._x = vec.x();
		this._y = vec.y();
		this._z = vec.z();
	}
	
	//Конструктор вектора через 2 точки
	public Vector3d (Vector3d vec1,Vector3d vec2){
		this._x = vec2.x()-vec1.x();
		this._y = vec2.y()-vec1.y();
		this._z = vec2.z()-vec1.z();
	}
	
    // функция вывода координат вектора в консоль
	public static void printVector (Vector3d vec){
		System.out.println("("+vec.x()+";"+vec.y()+";"+vec.z()+")");
	}

	// Функция сложения 2 векторов
	public Vector3d sum (Vector3d vec1, Vector3d vec2) {
		return new Vector3d (vec1.x()+vec2.x(),vec1.y()+vec2.y(),vec1.z()+vec2.z());
	}
	
    // Функция Умножения вектра на число
	public Vector3d multiNum (Vector3d vec1, double k) {
		return new Vector3d (vec1.x()*k,vec1.y()*k,vec1.z()*k);
	}
	
	// Функция скалярного произведения
	public double scalarProduct(Vector3d vec1, Vector3d vec2) {
		return vec1.x()*vec2.x()+vec1.y()*vec2.y()+vec1.z()*vec2.z();
	}
	
	// Функция векторного произведения 
	public static Vector3d vectProduct(Vector3d vec1, Vector3d vec2) {
		return new Vector3d (vec1.y()*vec2.z()-vec1.z()*vec2.y(),-(vec1.x()*vec2.z()-vec1.z()*vec2.x()),vec1.x()*vec2.y()-vec1.y()*vec2.x());
	}
	
	
	public String toString() {
        return "" + this.x() + " " + this.y() + " " + this.z() ;
    }

	
	
}
