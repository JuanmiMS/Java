package org.formacion.builder;

public class Persona {

    private String nombre;
    private int edad;
    private String municipio;
    private String colegio;
    private String lugarTrabajo;

    private Persona() {

    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public static class Builder {
        private Persona persona;

        public Builder(String nombre) {
            persona = new Persona();
            persona.nombre = nombre;
        }

        public Builder setMunicipio(String municipio) {
            persona.municipio = municipio;
            return this;
        }

        public Builder setMayor(int edad, String lugarTrabajo) {
            if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
            persona.edad = edad;
            persona.lugarTrabajo = lugarTrabajo;
            persona.colegio = null;
            return this;
        }

        public BuilderMayor setMayor(int edad) {
            if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
            persona.edad = edad;
            persona.colegio = null;
            return new BuilderMayor(persona);
        }

        public BuilderMenor setMenor(int edad) {
            if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
            persona.edad = edad;
            persona.lugarTrabajo = null;

            return persona.new BuilderMenor(persona);
        }


        public Builder setMenor(int edad, String colegio) {
            if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
            persona.edad = edad;
            persona.colegio = colegio;
            persona.lugarTrabajo = null;
            return this;
        }

        public Persona build() {
            return persona;
        }

    }

    public static class BuilderMayor {

        private Persona personaAdulta;

        public BuilderMayor(Persona persona) {
            personaAdulta = persona;
        }

        public BuilderMayor setLugarTrabajo(String lugarTrabajo) {
            personaAdulta.lugarTrabajo = lugarTrabajo;
            return this;
        }

        public Persona build() {
            return personaAdulta;
        }

    }

    public class BuilderMenor {

        private Persona personaMenor;

        public BuilderMenor(Persona persona) {
            personaMenor = persona;
        }

        public BuilderMenor setColegio(String colegio) {
            personaMenor.colegio = colegio;
            return this;
        }

        public Persona build() {
            return personaMenor;
        }

    }

}
