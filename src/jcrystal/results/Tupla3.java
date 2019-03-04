package jcrystal.results;
public class Tupla3<A,B,C>{
	public final A v0;
	public final B v1;
	public final C v2;
	public Tupla3(A v0,B v1,C v2){
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
	}
	public <D> Tupla4<A,B,C,D> append(D tupla){
		return new Tupla4<>(v0,v1,v2,tupla);
	}
	public <D,E> Tupla5<A,B,C,D,E> append(Tupla2<D,E> tupla){
		return new Tupla5<>(v0,v1,v2,tupla.v0,tupla.v1);
	}
	public <D,E,F> Tupla6<A,B,C,D,E,F> append(Tupla3<D,E,F> tupla){
		return new Tupla6<>(v0,v1,v2,tupla.v0,tupla.v1,tupla.v2);
	}
	public <D,E,F,G> Tupla7<A,B,C,D,E,F,G> append(Tupla4<D,E,F,G> tupla){
		return new Tupla7<>(v0,v1,v2,tupla.v0,tupla.v1,tupla.v2,tupla.v3);
	}
	public <D,E,F,G,H> Tupla8<A,B,C,D,E,F,G,H> append(Tupla5<D,E,F,G,H> tupla){
		return new Tupla8<>(v0,v1,v2,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4);
	}
	public <D,E,F,G,H,I> Tupla9<A,B,C,D,E,F,G,H,I> append(Tupla6<D,E,F,G,H,I> tupla){
		return new Tupla9<>(v0,v1,v2,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4,tupla.v5);
	}
	public <D,E,F,G,H,I,J> Tupla10<A,B,C,D,E,F,G,H,I,J> append(Tupla7<D,E,F,G,H,I,J> tupla){
		return new Tupla10<>(v0,v1,v2,tupla.v0,tupla.v1,tupla.v2,tupla.v3,tupla.v4,tupla.v5,tupla.v6);
	}
}
