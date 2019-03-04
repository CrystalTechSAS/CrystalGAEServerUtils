package jcrystal.results;
public class Tupla4<A,B,C,D>{
	public final A v0;
	public final B v1;
	public final C v2;
	public final D v3;
	public Tupla4(A v0,B v1,C v2,D v3){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	public Tupla4(Tupla2<A,B> tupla,C v2,D v3){
		this.v0 = tupla.v0;
		this.v1 = tupla.v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	public Tupla4(A v0,Tupla2<B,C> tupla,D v3){
		this.v0 = v0;
		this.v1 = tupla.v0;
		this.v2 = tupla.v1;
		this.v3 = v3;
	}
	public <E> Tupla5<A,B,C,D,E> append(E tupla){
		return new Tupla5<>(v0,v1,v2,v3,tupla);
	}
	public <E,F> Tupla6<A,B,C,D,E,F> append(Tupla2<E,F> tupla){
		return new Tupla6<>(v0,v1,v2,v3,tupla.v0,tupla.v1);
	}
	public <E,F,G> Tupla7<A,B,C,D,E,F,G> append(Tupla3<E,F,G> tupla){
		return new Tupla7<>(v0,v1,v2,v3,tupla.v0,tupla.v1,tupla.v2);
	}
	public <E,F,G,H> Tupla8<A,B,C,D,E,F,G,H> append(Tupla4<E,F,G,H> tupla){
		return new Tupla8<>(v0,v1,v2,v3,tupla.v0,tupla.v1,tupla.v2,tupla.v3);
	}
	public <E,F,G,H,I> Tupla9<A,B,C,D,E,F,G,H,I> append(Tupla5<E,F,G,H,I> tupla){
		return new Tupla9<>(v0,v1,v2,v3,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4);
	}
	public <E,F,G,H,I,J> Tupla10<A,B,C,D,E,F,G,H,I,J> append(Tupla6<E,F,G,H,I,J> tupla){
		return new Tupla10<>(v0,v1,v2,v3,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4,tupla.v5);
	}
}
