import { render, screen } from '@testing-library/react';
import Header from '../Components/Header';

describe('Header test', () => {
    test('Render del Header', () => {
        render(<Header />);
        const header = screen.getByText(/Header exist/i);
        expect(header).toBeInTheDocument();
    });

    test('Styles del header', () => {
        render(<Header />);
        const header = screen.getByRole('header','style header');
        expect(header).toHaveStyle({
            zindex: 2,
            background: rgb(255, 255, 255),
            position:sticky,
            top: 0,
            left: 0,
            width: 100,
            display: flex,
            flexwrap: wrap,
            justifycontent: space-between
        });
    });

    test('Components del Header', () => {
        render(<Header />);
        const cruz = screen.getByRole('links','equis');
        const saludo = screen.getByRole('paragraph','saludo');
        const user = screen.getByRole('paragraph','user');
        expect(cruz).toBeInTheDocument();
        expect(saludo).toBeInTheDocument();
        expect(user).toBeInTheDocument();
    });
});