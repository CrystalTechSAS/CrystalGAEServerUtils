package jcrystal.results;
public class Tupla2<A,B>{
	public final A v0;
	public final B v1;
	public Tupla2(A v0,B v1){
		this.v0 = v0;
		this.v1 = v1;
	}
	public <C> Tupla3<A,B,C> append(C tupla){
		return new Tupla3<>(v0,v1,tupla);
	}
	public <C,D> Tupla4<A,B,C,D> append(Tupla2<C,D> tupla){
		return new Tupla4<>(v0,v1,tupla.v0,tupla.v1);
	}
	public <C,D,E> Tupla5<A,B,C,D,E> append(Tupla3<C,D,E> tupla){
		return new Tupla5<>(v0,v1,tupla.v0,tupla.v1,tupla.v2);
	}
	public <C,D,E,F> Tupla6<A,B,C,D,E,F> append(Tupla4<C,D,E,F> tupla){
		return new Tupla6<>(v0,v1,tupla.v0,tupla.v1,tupla.v2,tupla.v3);
	}
	public <C,D,E,F,G> Tupla7<A,B,C,D,E,F,G> append(Tupla5<C,D,E,F,G> tupla){
		return new Tupla7<>(v0,v1,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4);
	}
	public <C,D,E,F,G,H> Tupla8<A,B,C,D,E,F,G,H> append(Tupla6<C,D,E,F,G,H> tupla){
		return new Tupla8<>(v0,v1,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4,tupla.v5);
	}
	public <C,D,E,F,G,H,I> Tupla9<A,B,C,D,E,F,G,H,I> append(Tupla7<C,D,E,F,G,H,I> tupla){
		return new Tupla9<>(v0,v1,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4,tupla.v5,tupla.v6);
	}
	public <C,D,E,F,G,H,I,J> Tupla10<A,B,C,D,E,F,G,H,I,J> append(Tupla8<C,D,E,F,G,H,I,J> tupla){
		return new Tupla10<>(v0,v1,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4,tupla.v5,tupla.v6,tupla.v7);
	}
}
