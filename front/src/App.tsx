import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Layout from './shared/Layout';
import Home from './pages/Home';
import Turmas from './pages/Turmas';
import Scanner from './pages/Scanner';
import Cadastrar from './pages/Cadastrar';
import Ajustes from './pages/Ajustes';

function App() {

  return (
    <BrowserRouter>
      <Routes>
        
        {/* Rota Pai: O Layout engloba todas as rotas filhas */}
        <Route path="/" element={<Layout />}>
          
          {/* Rotas Filhas: Injetadas no <Outlet /> */}
          <Route index element={<Home />} /> 
          <Route path="/Turmas" element={<Turmas />} />
          <Route path="/Scanner" element={<Scanner />} />
          <Route path="/Cadastrar" element={<Cadastrar />} />
          <Route path="/Ajustes" element={<Ajustes />} />
          
        </Route> {/* FIM DO ROTEADOR DO LAYOUT */}

      </Routes>
    </BrowserRouter>

  )
}


export default App
