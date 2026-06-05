import { createContext, useContext, useState, useEffect } from 'react';

// 1. Cria o contexto (inicializado como null por segurança)
const ThemeContext = createContext(null);

// 2. Cria o provedor (Provider)
export function ThemeProvider({ children }) {
  const [isDark, setIsDark] = useState(() => {
    // Tratamento para SSR (ex: Next.js) para evitar erro de "window is not defined"
    if (typeof window === 'undefined') return false;

    // Verifica primeiro o localStorage, depois a preferência do sistema operacional
    const savedTheme = localStorage.getItem('tema');
    if (savedTheme) return savedTheme === 'dark';
    
    return window.matchMedia('(prefers-color-scheme: dark)').matches;
  });
  
  // Aplica a classe/atributo no HTML global
  useEffect(() => {
    const root = window.document.documentElement;
    if (isDark) {
      root.setAttribute('data-theme', 'dark');
      localStorage.setItem('tema', 'dark');
    } else {
      root.removeAttribute('data-theme'); // Remove o atributo para voltar ao padrão
      localStorage.setItem('tema', 'light');
    }
  }, [isDark]);

  const toggleTheme = () => setIsDark((prev) => !prev);

  return (
    <ThemeContext.Provider value={{ isDark, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

// 3. Hook personalizado para facilitar o uso nos componentes

// eslint-disable-next-line react-refresh/only-export-components
export function useTheme() {
  const context = useContext(ThemeContext);
  
  // Verificação de segurança: garante que o hook não seja chamado fora do Provider
  if (!context) {
    throw new Error('useTheme deve ser usado dentro de um ThemeProvider');
  }
  
  return context;
}