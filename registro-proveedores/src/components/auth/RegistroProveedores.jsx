import React, { useState } from 'react';
import axios from 'axios';
import Swal from 'sweetalert2';

const RegistroProveedores = () => {
  const [proveedor, setProveedor] = useState({
    tipoPersona: '',
    nitRut: '',
    razonSocial: '',
    representanteLegal: '',
    telefono: '',
    email: '',
    ciudad: '',
    pais: '',
    departamento: '',
    direccion: '',
    archivoRut: null
  });


  


  const handleChange = (e) => {
    setProveedor({
      ...proveedor,
      [e.target.name]: e.target.value
    });
  };

  const handleFileChange = (e) => {
    setProveedor({
      ...proveedor,
      archivoRut: e.target.files[0]
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const formData = new FormData();
      for (const key in proveedor) {
        formData.append(key, proveedor[key]);
      }

      await axios.post('localhost:8080/prueba/v2/proveedor', formData);

      Swal.fire({
        title: '¡Proveedor registrado exitosamente!',
        text: 'El proveedor ha sido registrado correctamente.',
        icon: 'success'
      });
    } catch (error) {
      console.error('Error al registrar proveedor:', error);
      Swal.fire({
        title: '¡Error!',
        text: 'Hubo un error al registrar el proveedor. Por favor, inténtalo de nuevo.',
        icon: 'error'
      });
    }
  };

  return (
    <div className="bg-lime-300 min-h-screen flex items-center justify-center ">
        <div className='w-full max-w-md p-6 bg-white rounded-md shadow-md'>
      <h1 className="text-2xl font-bold my-4">Registro de Proveedores</h1>
      <form onSubmit={handleSubmit} className="space-y-4">
        <div className="block text-gray-700 text-sm font-bold mb-2">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="tipoPersona">Personería Jurídica:</label>
          <select  name="tipoPersona" id="tipoPersona" value={proveedor.tipoPersona} onChange={handleChange} className="w-full border-gray-300 rounded-md">
            <option value="">Seleccionar...</option>
            <option value="Persona natural">Persona natural</option>
            <option value="Persona jurídica">Persona jurídica</option>
          </select>
        </div>
        <div>
            <label
              htmlFor="nitRut"
              className="block text-gray-700 text-sm font-bold mb-2"
            >
              Nit/Cedula:
            </label>
            <input
              type="number"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              onChange={(e) => {
                setNombreRazonSocial(e.target.value);
              }}
            />
          </div>
        <div>
            <label
              htmlFor="razonSocial"
              className="block text-gray-700 text-sm font-bold mb-2"
            >
              Nombre Razon Social:
            </label>
            <input
              type="text"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              onChange={(e) => {
                setNombreRazonSocial(e.target.value);
              }}
            />
          </div>
          <div>
            <label
              htmlFor="nombreRepresentateLegal"
              className="block text-gray-700 text-sm font-bold mb-2"
            >
              Nombre Representate Legal:
            </label>
            <input
              type="text"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              onChange={(e) => {
                setNombreRazonSocial(e.target.value);
              }}
            />
          </div>
          <div>
            <label
              htmlFor="telefonoContacto"
              className="block text-gray-700 text-sm font-bold mb-2"
            >
              Telefono Contacto:
            </label>
            <input
              type="number"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              onChange={(e) => {
                setNombreRazonSocial(e.target.value);
              }}
            />
          </div>
          <div>
            <label
              htmlFor="email"
              className="block text-gray-700 text-sm font-bold mb-2"
            >
              Email:
            </label>
            <input
              type="text"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              onChange={(e) => {
                setNombreRazonSocial(e.target.value);
              }}
            />
          </div>
          <div className="block text-gray-700 text-sm font-bold mb-2">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="tipoPersona">Pais:</label>
          <select  name="tipoPersona" id="tipoPersona" value={proveedor.tipoPersona} onChange={handleChange} className="w-full border-gray-300 rounded-md">
            <option value="">Seleccionar...</option>
            <option value="Persona natural">Colombia</option>
            <option value="Persona jurídica">Argentina</option>
          </select>
        </div>
        <div className="block text-gray-700 text-sm font-bold mb-2">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="tipoPersona">Departamento</label>
          <select  name="tipoPersona" id="tipoPersona" value={proveedor.tipoPersona} onChange={handleChange} className="w-full border-gray-300 rounded-md">
            <option value="">Seleccionar...</option>
            <option value="Persona natural">Antioquia</option>
            <option value="Persona jurídica">Valle</option>
          </select>
        </div>
        <div className="block text-gray-700 text-sm font-bold mb-2">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="tipoPersona">Ciudad</label>
          <select  name="tipoPersona" id="tipoPersona" value={proveedor.tipoPersona} onChange={handleChange} className="w-full border-gray-300 rounded-md">
            <option value="">Seleccionar...</option>
            <option value="Persona natural">Medellin</option>
            <option value="Persona jurídica">Girardota</option>
          </select>
        </div>
        <div>
            <label
              htmlFor="direccion"
              className="block text-gray-700 text-sm font-bold mb-2"
            >
              Dirección:
            </label>
            <input
              type="text"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              onChange={(e) => {
                setNombreRazonSocial(e.target.value);
              }}
            />
          </div>
          <div>
  <label htmlFor="archivoRut" className="block text-gray-700 text-sm font-bold mb-2">Cargar RUT (Archivo PDF):</label>
  <input type="file" id="archivoRut" name="archivoRut" onChange={handleFileChange} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
</div>
          
        <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded-md">Registrar Proveedor</button>
      </form>
    </div>
    </div>
  );
};

export default RegistroProveedores;
