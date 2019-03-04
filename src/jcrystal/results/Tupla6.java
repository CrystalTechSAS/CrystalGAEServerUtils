package jcrystal.results;
public class Tupla6<A,B,C,D,E,F>{
	public final A v0;
	public final B v1;
	public final C v2;
	public final D v3;
	public final E v4;
	public final F v5;
	public Tupla6(A v0,B v1,C v2,D v3,E v4,F v5){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(Tupla2<A,B> tupla,C v2,D v3,E v4,F v5){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(A v0,Tupla2<B,C> tupla,D v3,E v4,F v5){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(A v0,B v1,Tupla2<C,D> tupla,E v4,F v5){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = tupla.v0;
		this.v3 = tupla.v1;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(A v0,B v1,C v2,Tupla2<D,E> tupla,F v5){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = tupla.v0;
		this.v4 = tupla.v1;
		this.v5 = v5;
	}
	public Tupla6(Tupla3<A,B,C> tupla,D v3,E v4,F v5){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = tupla.v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(A v0,Tupla3<B,C,D> tupla,E v4,F v5){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = tupla.v2;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(A v0,B v1,Tupla3<C,D,E> tupla,F v5){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = tupla.v0;
		this.v3 = tupla.v1;
		this.v4 = tupla.v2;
		this.v5 = v5;
	}
	public Tupla6(Tupla4<A,B,C,D> tupla,E v4,F v5){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = tupla.v2;
		this.v3 = tupla.v3;
		this.v4 = v4;
		this.v5 = v5;
	}
	public Tupla6(A v0,Tupla4<B,C,D,E> tupla,F v5){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = tupla.v2;
		this.v4 = tupla.v3;
		this.v5 = v5;
	}
	public <G> Tupla7<A,B,C,D,E,F,G> append(G tupla){
		return new Tupla7<>(v0,v1,v2,v3,v4,v5,tupla);
	}
	public <G,H> Tupla8<A,B,C,D,E,F,G,H> append(Tupla2<G,H> tupla){
		return new Tupla8<>(v0,v1,v2,v3,v4,v5,tupla.v0,tupla.v1);
	}
	public <G,H,I> Tupla9<A,B,C,D,E,F,G,H,I> append(Tupla3<G,H,I> tupla){
		return new Tupla9<>(v0,v1,v2,v3,v4,v5,tupla.v0,tupla.v1,tupla.v2);
	}
	public <G,H,I,J> Tupla10<A,B,C,D,E,F,G,H,I,J> append(Tupla4<G,H,I,J> tupla){
		return new Tupla10<>(v0,v1,v2,v3,v4,v5,tupla.v0,tupla.v1,tupla.v2,tupla.v3);
	}
}
