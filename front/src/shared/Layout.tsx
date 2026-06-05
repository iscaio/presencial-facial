import { Outlet, Link, useLocation } from 'react-router-dom';
import {
    LayoutDashboard,
    ScanFace,
    UserPlus,
    Settings,
    GraduationCap
} from 'lucide-react';

import { motion, LayoutGroup } from 'framer-motion';

import '../CSS/Layout.css';

function Layout() {

    const location = useLocation();

    const menuItems = [
        { icon: LayoutDashboard, label: 'Home', path: '/' },
        { icon: ScanFace, label: 'Scanner', path: '/Scanner' },
        { icon: UserPlus, label: 'Cadastro', path: '/Cadastrar' },
        { icon: GraduationCap, label: 'Turmas', path: '/Turmas' },
        { icon: Settings, label: 'Ajustes', path: '/Ajustes' },
    ];
    
    return (
    <>
        <main>
            <Outlet />
        </main>

        <section className="tab-bar-area">

            <LayoutGroup>

                <nav className="bottom-tab-bar">
                    {menuItems.map((item) => {
                        const Icon = item.icon;
                        const isActive = location.pathname === item.path;

                        return (
                            <motion.div
                                layout
                                key={item.path}
                                className="tab-item-wrapper"
                            >

                                <Link
                                    to={item.path}
                                    className="tab-item"
                                >

                                    {isActive && (
                                        <motion.div
                                            layoutId="activeTab"
                                            className="active-tab"
                                            transition={{
                                                type: "spring",
                                                stiffness: 300,
                                                damping: 25
                                            }}
                                        >
                                            <Icon className="active-icon" />
                                        </motion.div>
                                    )}

                                    <div className={`tab-icon ${ isActive ? 'hidden-icon' : '' }`}>
                                        <Icon />
                                    </div>

                                    <span className={`tab-label ${ isActive ? 'active-label' : '' }`}>
                                        {item.label}
                                    </span>

                                </Link>
                            </motion.div>
                        );
                    })}

                </nav>

            </LayoutGroup>
        </section>
    </>
    );
}

export default Layout;