<div class="row">
    <div class="col form-inline">
        <div class="form-group">
            <label for="filter" class="sr-only">Filter</label>
            <input id="filter" type="text" class="form-control" v-model="filter" placeholder="Filter">
        </div>
    </div>
</div>

<div class="row">
    <div id="table" class="col table-responsive">
        <datatable :columns="columns" :data="questoes" :filter-by="filter"></datatable>
    </div>
</div>

<div class="row">
    <div class="col btn-toolbar">
        <datatable-pager v-model="page" type="abbreviated" :per-page="per_page"></datatable-pager>
    </div>
</div>