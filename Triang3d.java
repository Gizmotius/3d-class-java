package Structur;

public class Triang3d {
	
	// переменные отвечающие за вершины треугольника
	private Vector3d _a;
	private Vector3d _b;
	private Vector3d _c;
	
	public Vector3d a(){
		return _a; 
	}
	public Vector3d b(){
		return _b; 
	}
	public Vector3d C(){
		return _c; 
	}
	
	public void a(Vector3d a){
		 this._a = a;
	}
	public void b(Vector3d b){
		 this._b = b;
	}
	public void C(Vector3d c){
		 this._c = c;
	}

	
	// конструктор с 9 аргументами (3 координаты первой точки, 3 координаты второй точки и 3 координаты третьей точки)
	public Triang3d (double x1, double y1, double z1,double x2, double y2, double z2,double x3, double y3, double z3){
		this._a = new Vector3d(x1,y1,z1);
	    this._b = new Vector3d(x2,y2,z2);
	    this._c = new Vector3d(x3,y3,z3);
	}
	
	// конструктор с 7 аргументами (данные первой точки, 3 координаты второй точки и 3 координаты третьей точки)
	public Triang3d (Vector3d a,double x2, double y2, double z2,double x3, double y3, double z3){
		this._a = a;
	    this._b = new Vector3d(x2,y2,z2);
	    this._c = new Vector3d(x3,y3,z3);
	}
	
	// конструктор с 5 аргументами (данные первой точки, данные второй точки и 3 координаты третьей точки)
	public Triang3d (Vector3d a,Vector3d b,double x3, double y3, double z3){
		this._a = a;
	    this._b = b;
	    this._c = new Vector3d(x3,y3,z3);
	}
	
	// конструктор с 5 аргументами (данные первой точки, 3 координаты второй точки и данные третьей точки)
	public Triang3d (Vector3d a,double x2, double y2, double z2,Vector3d c){
		this._a = a;
	    this._b = new Vector3d(x2,y2,z2);
	    this._c = c;
	}
	
	// конструктор с 7 аргументами ( 3 координаты первой точки, данные второй точки и 3 координаты третьей точки)
	public Triang3d (double x1, double y1, double z1,Vector3d b,double x3, double y3, double z3){
		this._a = new Vector3d(x1,y1,z1);
	    this._b = b;
	    this._c = new Vector3d(x3,y3,z3);
	}
	
	// конструктор с 7 аргументами ( 3 координаты первой точки, 3 координаты второй точки и данные третьей точки)
	public Triang3d (double x1, double y1, double z1,double x2, double y2, double z2,Vector3d c){
		this._a = new Vector3d(x1,y1,z1);
	    this._b = new Vector3d(x2,y2,z2);
	    this._c = c;
	}
	
	// конструктор с 5 аргументами (3 координаты первой точки, данные второй точки и данные третьей точки)
	public Triang3d (double x1, double y1, double z1,Vector3d b,Vector3d c){
		this._a = new Vector3d(x1,y1,z1);
	    this._b = b;
	    this._c = c;
	}
	
	// конструктор с 3 аргументами (данные первой точки, данные второй точки и данные третьей точки)
	public Triang3d (Vector3d a,Vector3d b,Vector3d c){
		this._a = a;
	    this._b = b;
	    this._c = c;
	}

	//функция нахождения площади площади по формуле Герона
	public double  square(Triang3d tri) {
		
		double ab = Rib3d.length(new Rib3d(tri.a(),tri.b()));
		double bc = Rib3d.length(new Rib3d(tri.b(),tri.C()));
		double ac = Rib3d.length(new Rib3d(tri.a(),tri.C()));
	
		double p = (ab+ac+bc)/2;
		
		return Math.sqrt(p*(p-ab)*(p-ac)*(p-bc));
	}
	
	//Медиана из вершины 
	public Rib3d  medianA(Triang3d tri) {
		return new Rib3d(tri.a(),new Vector3d((tri.b().x()+tri.C().x())/2, (tri.b().y()+tri.C().y())/2,(tri.b().z()+tri.C().z())/2));
	}
	public Rib3d  medianB(Triang3d tri) {
		return new Rib3d(tri.b(),new Vector3d((tri.a().x()+tri.C().x())/2, (tri.a().y()+tri.C().y())/2,(tri.a().z()+tri.C().z())/2));
	}
	public Rib3d  medianC(Triang3d tri) {
		return new Rib3d(tri.C(),new Vector3d((tri.a().x()+tri.b().x())/2, (tri.a().y()+tri.b().y())/2,(tri.a().z()+tri.b().z())/2));
	}
	public Rib3d median(Triang3d tri,Vector3d vec) {
		if (vec == tri.a()) return medianA(tri);
		else if (vec == tri.b()) return medianB(tri);
		else return medianC(tri);
	}
	
	//Биссектриса угла----
	
	// Функция для нахождения центра описанной окружности треугольника
	// Через систему 3 уравнений плоскостей 
	// (2 уравнения серединных перпендикуляров сторон и уравнение плоскости преугольника)  
	// Решение ситемы методом Крамера
	
	public static Vector3d centerCircleOfTriang (Triang3d tri) {
		// Пусть у нас треугольник АВС, тогда...
	    
		// Cередина АВ
		Vector3d point_m = new Vector3d((tri.a().x()+tri.b().x())/2, (tri.a().y()+tri.b().y())/2,(tri.a().z()+tri.b().z())/2);
		// Середина АС
		Vector3d point_n = new Vector3d((tri.a().x()+tri.C().x())/2, (tri.a().y()+tri.C().y())/2,(tri.a().z()+tri.C().z())/2);
		// Вектор АВ
		Vector3d vector_m = new Vector3d(tri.a(), tri.b());
		// Вектор АС
		Vector3d vector_n = new Vector3d(tri.a(), tri.C());
		// Векторное произведение [AB,AC]
		Vector3d vector_k = Vector3d.vectProduct(vector_m, vector_n);
		
		// Коэффиценты D в уравнениях плоскостей
		double pm=vector_m.x()*point_m.x()+vector_m.y()*point_m.y()+vector_m.z()*point_m.z();
		double pn=vector_n.x()*point_n.x()+vector_n.y()*point_n.y()+vector_n.z()*point_n.z();
		double pk=vector_k.x()*tri.a().x()+vector_k.y()*tri.a().y()+vector_k.z()*tri.a().z();
		
		// Главный определитель системы
		double det = vector_m.x()*(vector_n.y()*vector_k.z()-vector_n.z()*vector_k.y())-vector_m.y()*(vector_n.x()*vector_k.z()-vector_n.z()*vector_k.x())+vector_m.z()*(vector_n.x()*vector_k.y()-vector_n.y()*vector_k.x());
		
		// Вспомогательные определители системы
		double det_x = pm*(vector_n.y()*vector_k.z()-vector_n.z()*vector_k.y())-vector_m.y()*(pn*vector_k.z()-vector_n.z()*pk)+vector_m.z()*(pn*vector_k.y()-vector_n.y()*pk);
		double det_y = vector_m.x()*(pn*vector_k.z()-vector_n.z()*pk)-pm*(vector_n.x()*vector_k.z()-vector_n.z()*vector_k.x())+vector_m.z()*(vector_n.x()*pk-pn*vector_k.x());
		double det_z = vector_m.x()*(vector_n.y()*pk-pn*vector_k.y())-vector_m.y()*(vector_n.x()*pk-pn*vector_k.x())+pm*(vector_n.x()*vector_k.y()-vector_n.y()*vector_k.x());
		
		return new Vector3d(det_x/det, det_y/det, det_z/det);
	}
	
	
	
}
