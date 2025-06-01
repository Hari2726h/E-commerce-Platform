import React from "react";
import { Navigate, useLocation } from "react-router-dom";
import ApiService from "./ApiService";

// Custom wrapper to use hook in non-component
function withLocationGuard(ComponentCheck) {
  return function WrappedComponent(props) {
    const location = useLocation();
    return <ComponentCheck location={location} {...props} />;
  };
}

const ProtectedRouteComponent = ({ element, location }) => {
  return ApiService.isAuthenticated() ? (
    element
  ) : (
    <Navigate to="/login" replace state={{ from: location }} />
  );
};

const AdminRouteComponent = ({ element, location }) => {
  return ApiService.isAuthenticated() ? (
    element
  ) : (
    <Navigate to="/login" replace state={{ from: location }} />
  );
};

// Export wrapped versions
export const protectedRoute = withLocationGuard(ProtectedRouteComponent);
export const adminRoute = withLocationGuard(AdminRouteComponent);
