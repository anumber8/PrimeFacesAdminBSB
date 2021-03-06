package com.kurtomerfaruk.primeadminbsb.controllers;

import com.kurtomerfaruk.primeadminbsb.models.Productlistpricehistory;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productlistpricehistoryController")
@ViewScoped
public class ProductlistpricehistoryController extends AbstractController<Productlistpricehistory> {

    @Inject
    private ProductController productController;

    public ProductlistpricehistoryController() {
        // Inform the Abstract parent controller of the concrete Productlistpricehistory Entity
        super(Productlistpricehistory.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProductlistpricehistoryPK().setProductID(this.getSelected().getProduct().getProductID());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProductlistpricehistoryPK(new com.kurtomerfaruk.primeadminbsb.models.ProductlistpricehistoryPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        productController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Product controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProduct(ActionEvent event) {
        if (this.getSelected() != null && productController.getSelected() == null) {
            productController.setSelected(this.getSelected().getProduct());
        }
    }
}
