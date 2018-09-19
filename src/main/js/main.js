import {$, jQuery} from 'jquery';

window.$ = $;
window.jQuery = jQuery;

$(document).ready(function () {
    feather.replace();

    Sidebar.run();
});

