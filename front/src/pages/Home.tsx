import '../CSS/Home.css'
import { useTheme } from '../shared/theme/ThemeContext';
//import { motion } from 'framer-motion';

function Home() {

  const { isDark, toggleTheme } = useTheme();

  return (
    <>
      <section className="header-title">
        <h1 className="font-3xl">Gestão de Turmas</h1>
        <div className="button-conteiner">

          <button onClick={toggleTheme} className="glass btn">
                <span>Cadastrar Aluno</span>
          </button>

          <button onClick={toggleTheme} className="btn btn-primary">

            {isDark ? '☀️ Modo Claro' : '🌙 Modo Escuro'}

          </button>
        </div>
      </section>

      <section className="Boas-vindas">
        <h2 className="text-xl">Olá, professor Bruno Rafael !</h2>
        <p className="text-xs">Bem vindo ao sistema de controle de presença</p>
      </section>

        <div className="home home2">
        Home 2
        </div>

        <div className="home">
        Home
        </div>
    </>
  )
}

export default Home;
