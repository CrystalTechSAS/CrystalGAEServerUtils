package jcrystal.results;
public class Tupla7<A,B,C,D,E,F,G>{
	public final A v0;
	public final B v1;
	public final C v2;
	public final D v3;
	public final E v4;
	public final F v5;
	public final G v6;
	public Tupla7(A v0,B v1,C v2,D v3,E v4,F v5,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(Tupla2<A,B> tupla,C v2,D v3,E v4,F v5,G v6){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,Tupla2<B,C> tupla,D v3,E v4,F v5,G v6){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,B v1,Tupla2<C,D> tupla,E v4,F v5,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = tupla.v0;
		this.v3 = tupla.v1;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,B v1,C v2,Tupla2<D,E> tupla,F v5,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = tupla.v0;
		this.v4 = tupla.v1;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,B v1,C v2,D v3,Tupla2<E,F> tupla,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = tupla.v0;
		this.v5 = tupla.v1;
		this.v6 = v6;
	}
	public Tupla7(Tupla3<A,B,C> tupla,D v3,E v4,F v5,G v6){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = tupla.v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,Tupla3<B,C,D> tupla,E v4,F v5,G v6){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = tupla.v2;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,B v1,Tupla3<C,D,E> tupla,F v5,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = tupla.v0;
		this.v3 = tupla.v1;
		this.v4 = tupla.v2;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,B v1,C v2,Tupla3<D,E,F> tupla,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = tupla.v0;
		this.v4 = tupla.v1;
		this.v5 = tupla.v2;
		this.v6 = v6;
	}
	public Tupla7(Tupla4<A,B,C,D> tupla,E v4,F v5,G v6){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = tupla.v2;
		this.v3 = tupla.v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,Tupla4<B,C,D,E> tupla,F v5,G v6){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = tupla.v2;
		this.v4 = tupla.v3;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,B v1,Tupla4<C,D,E,F> tupla,G v6){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = tupla.v0;
		this.v3 = tupla.v1;
		this.v4 = tupla.v2;
		this.v5 = tupla.v3;
		this.v6 = v6;
	}
	public Tupla7(Tupla5<A,B,C,D,E> tupla,F v5,G v6){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = tupla.v2;
		this.v3 = tupla.v3;
		this.v4 = tupla.v4;
		this.v5 = v5;
		this.v6 = v6;
	}
	public Tupla7(A v0,Tupla5<B,C,D,E,F> tupla,G v6){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = tupla.v2;
		this.v4 = tupla.v3;
		this.v5 = tupla.v4;
		this.v6 = v6;
	}
	public <H> Tupla8<A,B,C,D,E,F,G,H> append(H tupla){
		return new Tupla8<>(v0,v1,v2,v3,v4,v5,v6,tupla);
	}
	public <H,I> Tupla9<A,B,C,D,E,F,G,H,I> append(Tupla2<H,I> tupla){
		return new Tupla9<>(v0,v1,v2,v3,v4,v5,v6,tupla.v0,tupla.v1);
	}
	public <H,I,J> Tupla10<A,B,C,D,E,F,G,H,I,J> append(Tupla3<H,I,J> tupla){
		return new Tupla10<>(v0,v1,v2,v3,v4,v5,v6,tupla.v0,tupla.v1,tupla.v2);
	}
}
