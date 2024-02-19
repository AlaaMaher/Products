package com.jetpackcompose.products.store.presentation.screens.productscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jetpackcompose.products.store.presentation.screens.components.ProductCard
import com.jetpackcompose.products.store.presentation.util.LoadingDialog
import com.jetpackcompose.products.store.presentation.util.components.MyTopAppBar

@Composable
internal fun ProductsScreen(
    viewModel : ProductScreenVM = hiltViewModel()
) {
    val state by viewModel.productsState.collectAsStateWithLifecycle()
    ProductsContent(state = state)

}

@Composable
fun ProductsContent(
    state: ProductsViewStates
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(title = "Products") }) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(state.products){
                product -> ProductCard(product = product)
            }


        }


    }

}