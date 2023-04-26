import { render, screen } from '@testing-library/react';
import Categories from '../Components/Categorias';

describe('Categories test', () => {
    test('Render de las categorias', () => {
        render(<Categories />);
        const categories = screen.getByText(/Categories exist/i);
        expect(categories).toBeInTheDocument();
    });

    test('Styles de las categorias', () => {
        render(<Categories />);
        const categories = screen.getByText(/Categories style/i);
        expect(categories).toHaveStyle({
            display: flex,
            width: 100,
            flexDirection: row,
            flexWrap: wrap,
            alignContent: center,
            justifyContent: center,
            alignItems: center
        });
    });

    test('Components de las categorias', () => {
        render(<Categories />);
        const categoriesImg = screen.getByRole('img','imagen de categoria');
        const categoriesDescripcion = screen.getByRole('paragraph','descripcion');
        expect(categoriesImg).toBeInTheDocument();
        expect(categoriesDescripcion).toBeInTheDocument();
    });

});