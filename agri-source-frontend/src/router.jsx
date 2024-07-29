import { createBrowserRouter } from 'react-router-dom';
import Home from './pages/Home';
import MeetFarmers from './pages/MeetFarmers';
import ProductList from './pages/ProductList';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />,
  },
  {
    path: 'Meet',
    element: <MeetFarmers />,
  },
  {
    path: 'products',
    element: <ProductList />,
  },
]);
