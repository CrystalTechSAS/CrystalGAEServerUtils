package jcrystal.results;
public class Tupla5<A,B,C,D,E>{
	public final A v0;
	public final B v1;
	public final C v2;
	public final D v3;
	public final E v4;
	public Tupla5(A v0,B v1,C v2,D v3,E v4){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
	}
	public Tupla5(Tupla2<A,B> tupla,C v2,D v3,E v4){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
	}
	public Tupla5(A v0,Tupla2<B,C> tupla,D v3,E v4){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = v3;
		this.v4 = v4;
	}
	public Tupla5(A v0,B v1,Tupla2<C,D> tupla,E v4){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = tupla.v0;
		this.v3 = tupla.v1;
		this.v4 = v4;
	}
	public Tupla5(Tupla3<A,B,C> tupla,D v3,E v4){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = tupla.v2;
		this.v3 = v3;
		this.v4 = v4;
	}
	public Tupla5(A v0,Tupla3<B,C,D> tupla,E v4){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = tupla.v2;
		this.v4 = v4;
	}
	public <F> Tupla6<A,B,C,D,E,F> append(F tupla){
		return new Tupla6<>(v0,v1,v2,v3,v4,tupla);
	}
	public <F,G> Tupla7<A,B,C,D,E,F,G> append(Tupla2<F,G> tupla){
		return new Tupla7<>(v0,v1,v2,v3,v4,tupla.v0,tupla.v1);
	}
	public <F,G,H> Tupla8<A,B,C,D,E,F,G,H> append(Tupla3<F,G,H> tupla){
		return new Tupla8<>(v0,v1,v2,v3,v4,tupla.v0,tupla.v1,tupla.v2);
	}
	public <F,G,H,I> Tupla9<A,B,C,D,E,F,G,H,I> append(Tupla4<F,G,H,I> tupla){
		return new Tupla9<>(v0,v1,v2,v3,v4,tupla.v0,tupla.v1,tupla.v2,tupla.v3);
	}
	public <F,G,H,I,J> Tupla10<A,B,C,D,E,F,G,H,I,J> append(Tupla5<F,G,H,I,J> tupla){
		return new Tupla10<>(v0,v1,v2,v3,v4,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4);
	}
}
