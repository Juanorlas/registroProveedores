import React from "react";
import { Link } from "react-router-dom";

const NavBar = () => {
  return (

    // fixed top-0 left-0 w-full z-50

    <nav>
      <div className="h-10vh flex justify-between z-50 text-white lg:py-5 px-20 py-4 flex-1">
        <div className="flex items-center flex-1">
          <span className="text-3xl font-bold">REGISTRO DE PROVEEDORES</span>
        </div>
        <div className="lg:flex md:flex lg:flex-1 items-center justify-end font-normal hidden">
          <div className="flex-10">
            <ul className="flex gap-8 mr-16 text-[18px]">
              <li>
                <Link to="/">
                  <span className="hover:text-sky-600 transition border-b-2 border-slate-900 hover:border-sky-600 cursor-pointer">
                    Inicio
                  </span>
                </Link>
              </li>
              <li>
                <Link to="/registroProveedores">
                  <span className="hover:text-sky-600 transition border-b-2 border-slate-900 hover:border-sky-600 cursor-pointer">
                    Registrar Proveedor
                  </span>
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default NavBar;
